package mx.com.ananda.ometecuhtli.quetzalcoatl.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item_contado")
public class ItemLocalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItem_local")
    private Long idItemLocal;

    @Column(name = "itemCode_local")
    private String codigoArticuloLocal;

    @Column(name = "itemName_local")
    private String itemNameLocal;

    @Column(name = "itemStock_local")
    private double sumaCantidadLocal;

    @Column(name = "itemWhs_local")
    private String almacenLocal;
}
