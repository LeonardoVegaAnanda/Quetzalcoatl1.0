package mx.com.ananda.ometecuhtli.quetzalcoatl.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.dto.ItemDTO;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.ItemUnicoModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.RegistrosInventarioModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IRegistrosInventarioRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemSAPService;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemUnicoService;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IRegistroInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RegistroServiceImpl implements IRegistroInventarioService {

    @Autowired
    private IRegistrosInventarioRepository iRegistros;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IItemUnicoService sItemUnico;

    @Value("${spring.external.service.base-url}")
    private String basePath;


    @Override
    public List<RegistrosInventarioModel> listRegistros() {
        return iRegistros.findAll();
    }

    @Override
    public List<RegistrosInventarioModel> listRegistrosByEquipo(String numEqipo) {
        return iRegistros.findByEquipoAsignado(numEqipo);
    }

    @Override
    public List<RegistrosInventarioModel> listRegistrosByRonda(int ronda) {
        return iRegistros.findByRondaRegistro(ronda);
    }

    @Override
    public List<RegistrosInventarioModel> listRegistroByUbicacion(String ubicacion) {
        return iRegistros.findByUbicacionRegistro(ubicacion);
    }

    @Override
    public Optional<RegistrosInventarioModel> getRegistroById(Long idRegistro) {
        return iRegistros.findById(idRegistro);
    }

    @Override
    public Optional<RegistrosInventarioModel> getRegistroByItemCode(String itemCode) {
        return iRegistros.findByCodigoArticuloRegistro(itemCode);
    }

    @Override
    public RegistrosInventarioModel saveRegistro(RegistrosInventarioModel registro) {
        log.info("DATOS DEL REGISTRO: {}", registro);
        Optional<ItemUnicoModel> oItem = sItemUnico.findByItemCode(registro.getCodigoArticuloRegistro(), registro.getUbicacionRegistro());
        ItemUnicoModel itemTraido = oItem.get();
        if (oItem.isEmpty()) {
            return null;
        } else {
            if (registro.getCantidadRegistro().equals(oItem.get().getCantidadUnico())) {
                registro.setCoincidenciaRegistro(true);
                log.info("EL REGISTRO COINICIDE CON LA CANTIDAD EN SAP");
                iRegistros.save(registro);
                Optional<RegistrosInventarioModel> registroTraido = iRegistros.findByCodigoArticuloRegistroAndUbicacionRegistro(oItem.get().getCodigoArticuloUnico(),oItem.get().getUbicacionUnico());
                return registroTraido.get();
            } else {
                registro.setCoincidenciaRegistro(false);
                log.info("EL REGISTRO NO COINICIDE CON LA CANTIDAD EN SAP");
                iRegistros.save(registro);
                Optional<RegistrosInventarioModel> registroTraido = iRegistros.findByCodigoArticuloRegistroAndUbicacionRegistro(oItem.get().getCodigoArticuloUnico(),oItem.get().getUbicacionUnico());
                return registroTraido.get();
            }
        }

    }

    @Override
    public void deleteRegistroById(Long id) {
        iRegistros.deleteById(id);
    }

    @Override
    public void updateRegistro(RegistrosInventarioModel registro) {
        iRegistros.save(registro);
    }

    private ItemUnicoModel mapearEntidadUnico(ItemDTO itemDTO) {
        ItemUnicoModel itemUnico = new ItemUnicoModel();
        itemUnico.setCantidadUnico(itemDTO.getStockUbicacion());
        itemUnico.setNombreArticuloUnico(itemDTO.getItemName());
        itemUnico.setCodigoArticuloUnico(itemDTO.getItemCode());
        itemUnico.setUbicacionUnico(itemDTO.getBinCode());
        itemUnico.setCodigoBarrasUnico(itemDTO.getCodeBars());
        itemUnico.setCodigoAlmacenUnico(itemDTO.getWhsCode());
        return itemUnico;

    }
}
