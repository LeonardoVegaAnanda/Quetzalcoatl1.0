package mx.com.ananda.ometecuhtli.quetzalcoatl.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "item_contado")
public class ItemContado {
    @Id
    private Long idItem;

    private String itemCode;

    private String itemName;

    private double sumaCantidad;

    private String almacen;
}
