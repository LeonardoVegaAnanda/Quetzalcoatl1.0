package mx.com.ananda.ometecuhtli.quetzalcoatl.repository;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.RegistrosInventarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRegistrosInventarioRepository extends JpaRepository<RegistrosInventarioModel,Long> {
    List<RegistrosInventarioModel> findByUbicacionRegistro(String ubicacionRegistro);
    Optional<RegistrosInventarioModel> findByCodigoArticuloRegistroAndUbicacionRegistro(String codigoArticuloRegistro, String ubicacionRegistro);
    Optional<RegistrosInventarioModel> findByCodigoArticuloRegistro(String codigoArticuloRegistro);
    List<RegistrosInventarioModel> findByRondaRegistro(Integer rondaRegistro);
    List<RegistrosInventarioModel> findByEquipoAsignado(String equipoAsignado);
}
