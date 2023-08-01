package mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ubicacion_sap")
public class UbicacionSAPModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Long idUbicacionSAP;

    @Column(name = "binCode_ubicacion")
    private String BinCode;

    @Column(name = "whsCode_ubicacion")
    private String WhsCode;

    @Column(name = "stock_ubicacion")
    private double StockUbicacion;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private ItemSAPModel itemSAP;
}
