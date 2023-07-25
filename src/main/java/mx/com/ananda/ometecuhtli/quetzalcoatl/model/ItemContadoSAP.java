package mx.com.ananda.ometecuhtli.quetzalcoatl.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "item_contado_sap")
public class ItemContadoSAP {

    @Id
    private Long idItem;

    private String itemCode;

    private String itemName;

    private String ubicacion;

    private Double cantidad;
}
