package mx.com.ananda.ometecuhtli.quetzalcoatl.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemInventario {

    private String itemCode;
    private String itemName;
    private String CodeBars;
    private String whsCode;
    private Double stockAlmacen;
    private List<UbicacionInventario> ubicacionesItems;

}
