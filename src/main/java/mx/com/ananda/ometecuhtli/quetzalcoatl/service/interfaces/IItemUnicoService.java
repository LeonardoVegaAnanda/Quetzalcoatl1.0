package mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.ItemUnicoModel;

import java.util.List;
import java.util.Optional;

public interface IItemUnicoService {

    List<ItemUnicoModel> listItemUnico();

    Optional<ItemUnicoModel> findByItemCode(String itemCode,String ubicacion);

}
