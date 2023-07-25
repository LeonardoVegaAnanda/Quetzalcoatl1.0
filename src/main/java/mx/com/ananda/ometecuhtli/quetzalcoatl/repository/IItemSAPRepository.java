package mx.com.ananda.ometecuhtli.quetzalcoatl.repository;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.ItemSAPModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IItemSAPRepository extends JpaRepository<ItemSAPModel,Long> {
    Optional<ItemSAPModel> findByCodigoArticuloSAP(String codigoArticuloSAP);
}
