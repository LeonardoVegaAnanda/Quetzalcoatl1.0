package mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity;

import lombok.Data;
import mx.com.ananda.ometecuhtli.quetzalcoatl.model.dto.UbicacionInventario;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "item_sap")
public class ItemSAPModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItem_sap")
    private Long idItemSAP;

    @Column(name = "itemName_sap")
    private String itemName;

    @Column(name = "itemCode_sap")
    private String itemCode;

    @Column(name = "codeBars_sap")
    private String codeBars;

    @Column(name = "whsCode_sap")
    private String whsCode;

    @Column(name = "stockAlmacen")
    private String stockAlmacen;

    @Nullable
    @OneToMany(mappedBy = "itemSAP")
    private List<UbicacionSAPModel> ubicacionesItems;

}
