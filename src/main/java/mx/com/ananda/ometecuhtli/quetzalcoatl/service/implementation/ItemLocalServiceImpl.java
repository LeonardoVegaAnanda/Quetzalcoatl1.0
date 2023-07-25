package mx.com.ananda.ometecuhtli.quetzalcoatl.service.implementation;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.ItemLocalModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.ItemUnicoModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.UbicacionModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IItemLocalRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IItemUnicoRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IUbicacionRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemLocalService;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemUnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemLocalServiceImpl implements IItemLocalService {


    @Autowired
    private IItemLocalRepository iItemLocal;

    @Autowired
    private IUbicacionRepository iUbicacion;

    @Override
    public List<ItemLocalModel> listItemlocal() {
        return iItemLocal.findAll();
    }

    @Override
    public List<UbicacionModel> listUbicacionByItem() {
        return iUbicacion.findAll();
    }

    @Override
    public Optional<ItemLocalModel> getItemLocalByOd(Long idItemLocal) {
        return iItemLocal.findById(idItemLocal);
    }

    @Override
    public Optional<ItemLocalModel> getItemLocalByItemCode(String itemCode) {
        return iItemLocal.findByCodigoArticuloLocal(itemCode);
    }


}
