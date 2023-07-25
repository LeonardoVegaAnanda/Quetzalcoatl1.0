package mx.com.ananda.ometecuhtli.quetzalcoatl.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "registros_invetario")
public class RegistrosInventario {
    @Id
    private Long idRegistro;

    private String equipoAsignado;

    private String itemCode;

    private Double cantidad;

    private String ubicacion;
}
