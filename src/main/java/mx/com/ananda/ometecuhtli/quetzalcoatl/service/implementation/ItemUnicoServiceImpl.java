package mx.com.ananda.ometecuhtli.quetzalcoatl.service.implementation;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.ItemUnicoModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IItemUnicoRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemUnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemUnicoServiceImpl implements IItemUnicoService {

    @Autowired
    private IItemUnicoRepository iItemUnico;

    @Override
    public List<ItemUnicoModel> listItemUnico() {
        return iItemUnico.findAll();
    }
}
