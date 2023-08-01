package mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registros_invetario")
public class RegistrosInventarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long idRegistro;

    @Column(name = "registro_assignedTeam")
    private String equipoAsignado;

    @Column(name = "registro_itemCode")
    private String codigoArticuloRegistro;

    @Column(name = "registro_stock")
    private Double cantidadRegistro;

    @Column(name = "registro_binCode")
    private String ubicacionRegistro;

    @Column(name = "registro_round")
    private Integer rondaRegistro;

    @Column(name = "registro_equals")
    private Boolean coincidenciaRegistro;
}
