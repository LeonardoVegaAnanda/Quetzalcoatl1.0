package mx.com.ananda.ometecuhtli.quetzalcoatl.repository;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.UbicacionSAPModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUbicacionRepository extends JpaRepository<UbicacionSAPModel,Long> {
}
