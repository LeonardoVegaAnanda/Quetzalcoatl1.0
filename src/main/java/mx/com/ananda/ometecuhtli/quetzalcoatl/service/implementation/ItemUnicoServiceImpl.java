package mx.com.ananda.ometecuhtli.quetzalcoatl.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.dto.ItemDTO;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.ItemSAPModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.ItemUnicoModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IItemUnicoRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemSAPService;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemUnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ItemUnicoServiceImpl implements IItemUnicoService {

    @Autowired
    private IItemUnicoRepository iItemUnico;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IItemSAPService sItemSAP;

    @Value("${spring.external.service.base-url}")
    private String basePath;

    @Override
    public List<ItemUnicoModel> listItemUnico() {
        return iItemUnico.findAll();
    }

    @Override
    public Optional<ItemUnicoModel> findByItemCode(String itemCode, String ubicacion) {

        Optional<ItemUnicoModel> oItemUnico = iItemUnico.findByCodigoArticuloUnicoAndUbicacionUnico(itemCode,ubicacion);

        if (oItemUnico.isEmpty()) {
            ItemUnicoModel itemSAPUnico = mapearEntidadUnico(restTemplate.getForObject(basePath
                    + "/item/tlaloc/unico?itemCode=" + itemCode
                    + "&ubicacion=" + ubicacion, ItemDTO.class));
            log.info("Item Traido unico: {}", itemSAPUnico.getUbicacionUnico());
            if (itemSAPUnico.getUbicacionUnico() != null) {
                log.info("Existe el articulo y la ubicacion");
                iItemUnico.save(itemSAPUnico);
                Optional<ItemSAPModel> itemSAP = sItemSAP.getItemSAPByItemCode(itemSAPUnico.getCodigoArticuloUnico(), itemSAPUnico.getCodigoAlmacenUnico());
                Optional<ItemUnicoModel> itemTraido = iItemUnico.findByCodigoArticuloUnicoAndUbicacionUnico(itemSAP.get().getItemCode(),ubicacion);
                return itemTraido;
            } else {
                log.info("No existe el articulo o su ubicacion");
                ItemUnicoModel itenNuevoNoSAP = new ItemUnicoModel();
                itenNuevoNoSAP.setUbicacionUnico(ubicacion);
                itenNuevoNoSAP.setCodigoArticuloUnico(itemCode);
                iItemUnico.save(itenNuevoNoSAP);
                Optional<ItemUnicoModel> itemNoTraido = iItemUnico.findByCodigoArticuloUnicoAndUbicacionUnico(itemCode,ubicacion);
                return itemNoTraido;
            }
        }
        else{
           return oItemUnico;
        }

    }

    private ItemUnicoModel mapearEntidadUnico(ItemDTO itemDTO) {
        ItemUnicoModel itemUnico = new ItemUnicoModel();
        itemUnico.setCantidadUnico(itemDTO.getStockUbicacion());
        itemUnico.setCodigoArticuloUnico(itemDTO.getItemCode());
        itemUnico.setCodigoBarrasUnico(itemDTO.getCodeBars());
        itemUnico.setCodigoAlmacenUnico(itemDTO.getWhsCode());
        itemUnico.setUbicacionUnico(itemDTO.getBinCode());
        itemUnico.setNombreArticuloUnico(itemDTO.getItemName());
        return itemUnico;
    }
}
