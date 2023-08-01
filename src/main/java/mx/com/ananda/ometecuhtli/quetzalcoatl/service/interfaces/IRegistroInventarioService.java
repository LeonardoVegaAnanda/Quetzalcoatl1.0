package mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.RegistrosInventarioModel;

import java.util.List;
import java.util.Optional;

public interface IRegistroInventarioService {

    List<RegistrosInventarioModel> listRegistros();

    List<RegistrosInventarioModel> listRegistrosByEquipo(String numEqipo);

    List<RegistrosInventarioModel> listRegistrosByRonda(int ronda);

    List<RegistrosInventarioModel> listRegistroByUbicacion(String ubicacion);

    Optional<RegistrosInventarioModel> getRegistroById(Long idRegistro);

    Optional<RegistrosInventarioModel> getRegistroByItemCode(String itemCode);

    RegistrosInventarioModel saveRegistro(RegistrosInventarioModel registro);

    void deleteRegistroById(Long id);

    void updateRegistro(RegistrosInventarioModel registro);
}
