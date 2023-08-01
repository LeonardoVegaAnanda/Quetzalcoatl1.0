package mx.com.ananda.ometecuhtli.quetzalcoatl.model.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private String BinCode;
    private String ItemCode;
    private String ItemName;
    private String WhsCode;
    private String CodeBars;
    private Double StockUbicacion;
}
