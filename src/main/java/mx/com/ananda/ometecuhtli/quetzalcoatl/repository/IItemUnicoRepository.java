package mx.com.ananda.ometecuhtli.quetzalcoatl.repository;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.ItemUnicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IItemUnicoRepository extends JpaRepository<ItemUnicoModel,Long> {
    Optional<ItemUnicoModel> findByCodigoArticuloUnicoAndUbicacionUnico(String codigoArticuloUnico, String ubicacionUnico);
    Optional<ItemUnicoModel> findByCodigoArticuloUnico(String codigoArticuloUnico);

}
