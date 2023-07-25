package mx.com.ananda.ometecuhtli.quetzalcoatl.repository;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.RegistrosInventarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRegistrosInventarioRepository extends JpaRepository<RegistrosInventarioModel,Long> {
    Optional<RegistrosInventarioModel> findByCodigoArticuloRegistro(String codigoArticuloRegistro);
    List<RegistrosInventarioModel> findByRondaRegistro(Integer rondaRegistro);
    List<RegistrosInventarioModel> findByEquipoAsignado(String equipoAsignado);
}
