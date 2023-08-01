package mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.ItemSAPModel;

import java.util.List;
import java.util.Optional;

public interface IItemSAPService {

    List<ItemSAPModel> listItemSAP();

    Optional<ItemSAPModel> getItemSAPById(Long idItemSAP);

    Optional<ItemSAPModel> getItemSAPByItemCode(String itemCode,String Almacen);
}
