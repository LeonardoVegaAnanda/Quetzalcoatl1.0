package mx.com.ananda.ometecuhtli.quetzalcoatl.repository;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.ItemLocalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IItemLocalRepository extends JpaRepository<ItemLocalModel,Long> {
    Optional<ItemLocalModel> findByCodigoArticuloLocal(String codigoArticuloLocal);
}
