package mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item_contado_sap")
public class ItemUnicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItem_unico")
    private Long idItemUnico;

    @Column(name = "itemCode_unico")
    private String codigoArticuloUnico;

    @Column(name = "itemName_unico")
    private String nombreArticuloUnico;

    @Column(name = "itemUbicacion_unico")
    private String ubicacionUnico;

    @Column(name = "itemStock_unico")
    private Double cantidadUnico;

    @Column(name = "codeBars_unico")
    private String codigoBarrasUnico;

    @Column(name = "whsCode_unico")
    private String codigoAlmacenUnico;
}
