package mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.ItemLocalModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.UbicacionModel;

import java.util.List;
import java.util.Optional;

public interface IItemLocalService {

    List<ItemLocalModel> listItemlocal();

    List<UbicacionModel> listUbicacionByItem();

    Optional<ItemLocalModel> getItemLocalByOd(Long idItemLocal);

    Optional<ItemLocalModel> getItemLocalByItemCode(String itemCode);
}
