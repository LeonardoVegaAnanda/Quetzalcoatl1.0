package mx.com.ananda.ometecuhtli.quetzalcoatl.repository;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.ItemUnicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemUnicoRepository extends JpaRepository<ItemUnicoModel,Long> {
}
