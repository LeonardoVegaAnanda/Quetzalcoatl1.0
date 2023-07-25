package mx.com.ananda.ometecuhtli.quetzalcoatl.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item_sap")
public class ItemSAPModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItem_sap")
    private Long idItemSAP;

    @Column(name = "itemCode_sap")
    private String codigoArticuloSAP;

    @Column(name = "itemName_sap")
    private String nombreArticuloSAP;

    @Column(name = "itemStock_sap")
    private double cantidadSAP;

    @Column(name = "itemWhs_sap")
    private String almacenSAP;
}
