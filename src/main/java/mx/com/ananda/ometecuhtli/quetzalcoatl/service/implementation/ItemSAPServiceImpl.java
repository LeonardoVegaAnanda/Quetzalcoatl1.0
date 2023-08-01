package mx.com.ananda.ometecuhtli.quetzalcoatl.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.dto.ItemInventario;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.dto.UbicacionInventario;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.ItemSAPModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.UbicacionSAPModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IItemSAPRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IUbicacionRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemSAPService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemSAPServiceImpl implements IItemSAPService {

    @Autowired
    private IItemSAPRepository iItemSAP;

    @Autowired
    private IUbicacionRepository iUbicacion;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;


    @Value("${spring.external.service.base-url}")
    private String basePath;

    @Override
    public List<ItemSAPModel> listItemSAP() {
        return iItemSAP.findAll();
    }

    @Override
    public Optional<ItemSAPModel> getItemSAPById(Long idItemSAP) {
        return iItemSAP.findById(idItemSAP);
    }

    @Override
    public Optional<ItemSAPModel> getItemSAPByItemCode(String itemCode,String almacen) {
        Optional<ItemSAPModel> oSAP = iItemSAP.findByItemCodeAndWhsCode(itemCode,almacen);
        if(oSAP.isEmpty()) {
            ItemSAPModel itemSAP = mapearEntidadItemSAP(restTemplate.getForObject
                    (basePath + "/item/tlaloc/almacen?itemCode="
                            + itemCode + "&almacen=" + almacen, ItemInventario.class));
            log.info("Item Traido: {}", itemSAP);
            if (itemSAP != null) {
                ItemInventario itemInventario = restTemplate.getForObject (basePath + "/item/tlaloc/almacen?itemCode="
                        + itemCode + "&almacen=" + almacen, ItemInventario.class);
                List<UbicacionSAPModel> listaUbicaciones = new ArrayList<>();
                for(var ubicacion:itemInventario.getUbicacionesItems()){
                    listaUbicaciones.add(mapearEntidadUbicacion(ubicacion));
                    for(UbicacionSAPModel ubi:listaUbicaciones){
                        Optional<ItemSAPModel> itemTraido = iItemSAP.findByItemCode(itemCode);
                        if(itemTraido.isPresent()){
                            ubi.setItemSAP(itemTraido.get());
                            iUbicacion.save(ubi);
                        }
                        else{
                            ItemSAPModel itemNuevo =  null;
                            try{
                                itemNuevo = iItemSAP.save(itemSAP);
                            }
                            catch (Exception e){
                                throw  new RuntimeException(e);
                            }
                            ubi.setItemSAP(itemNuevo);
                            iUbicacion.save(ubi);
                        }
                    }
                }
                Optional<ItemSAPModel> itemDevuelto = iItemSAP.findByItemCodeAndWhsCode(itemCode,almacen);
                return itemDevuelto;
            }
        }
        else {
            return oSAP;
        }
        return null;
    }

    private ItemSAPModel mapearEntidadItemSAP(ItemInventario itemInv){
        ItemSAPModel item = modelMapper.map(itemInv, ItemSAPModel.class);
        return item;
    }

    private UbicacionSAPModel mapearEntidadUbicacion(UbicacionInventario ubicacionInventario){
        UbicacionSAPModel ubicacion = new UbicacionSAPModel();
        ubicacion.setStockUbicacion(ubicacionInventario.getStockUbicacion());
        ubicacion.setWhsCode(ubicacionInventario.getWhsCode());
        ubicacion.setBinCode(ubicacionInventario.getBinCode());
        return ubicacion;
    }


}
