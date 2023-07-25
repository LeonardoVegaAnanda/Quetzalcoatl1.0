package mx.com.ananda.ometecuhtli.quetzalcoatl.service.implementation;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.ItemSAPModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IItemSAPRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemSAPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemSAPServiceImpl implements IItemSAPService {

    @Autowired
    private IItemSAPRepository iItemSAP;

    @Override
    public List<ItemSAPModel> listItemSAP() {
        return iItemSAP.findAll();
    }

    @Override
    public Optional<ItemSAPModel> getItemSAPById(Long idItemSAP) {
        return iItemSAP.findById(idItemSAP);
    }

    @Override
    public Optional<ItemSAPModel> getItemSAPByItemCode(String itemCode) {
        return iItemSAP.findByCodigoArticuloSAP(itemCode);
    }
}
