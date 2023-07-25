package mx.com.ananda.ometecuhtli.quetzalcoatl.service.implementation;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.RegistrosInventarioModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.repository.IRegistrosInventarioRepository;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IRegistroInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroServiceImpl implements IRegistroInventarioService {

    @Autowired
    private IRegistrosInventarioRepository iRegistros;

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
    public Optional<RegistrosInventarioModel> getRegistroById(Long idRegistro) {
        return iRegistros.findById(idRegistro);
    }

    @Override
    public Optional<RegistrosInventarioModel> getRegistroByItemCode(String itemCode) {
        return iRegistros.findByCodigoArticuloRegistro(itemCode);
    }

    @Override
    public RegistrosInventarioModel saveRegistro(RegistrosInventarioModel registro) {
        return iRegistros.save(registro);
    }

    @Override
    public void deleteRegistroById(Long id) {
        iRegistros.deleteById(id);
    }

    @Override
    public void updateRegistro(RegistrosInventarioModel registro) {
        iRegistros.save(registro);
    }
}
