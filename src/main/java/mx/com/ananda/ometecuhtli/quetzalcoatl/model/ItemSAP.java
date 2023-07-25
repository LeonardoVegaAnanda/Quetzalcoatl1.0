package mx.com.ananda.ometecuhtli.quetzalcoatl.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "item_sap")
public class ItemSAP {
    @Id
    private Long idItem;

    private String itemCode;

    private String itemName;

    private double cantidad;

    private String almacen;
}
