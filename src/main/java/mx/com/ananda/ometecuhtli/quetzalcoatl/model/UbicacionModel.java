package mx.com.ananda.ometecuhtli.quetzalcoatl.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ubicacion")
public class UbicacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Long idUbicacion;

    @Column(name = "ubicacion_binCode")
    private String nombreUbicacion;

    @Column(name = "ubicacion_whsCode")
    private String codigoUbicacion;

    @Column(name = "ubicacion_stock")
    private Double cantidadUbicacion;
}
