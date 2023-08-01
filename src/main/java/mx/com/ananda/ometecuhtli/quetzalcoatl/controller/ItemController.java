package mx.com.ananda.ometecuhtli.quetzalcoatl.controller;

import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemSAPService;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IItemUnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ananda/ometecuhtli/quetzalcoatl/item")
public class ItemController {

    @Autowired
    private IItemSAPService sItemSAP;

    @Autowired
    private IItemUnicoService sItemUnico;



    @GetMapping("/unico")
    public ResponseEntity<?> obtenerItemsUnicos(){
        return new ResponseEntity<>(sItemUnico.listItemUnico(),HttpStatus.OK);
    }

    @GetMapping("/sap")
    public ResponseEntity<?> obtenerItemsSAP(){
        return new ResponseEntity<>(sItemSAP.listItemSAP(),HttpStatus.OK);
    }

    @GetMapping("/sap/{id}")
    public ResponseEntity<?> obtenerItemSAPById(@PathVariable Long idItemSAP){
        return new ResponseEntity<>(sItemSAP.getItemSAPById(idItemSAP),HttpStatus.OK);
    }

    @GetMapping("/sap/itemCode")
    public ResponseEntity<?> obtenerItemSAPByItemCode(@RequestParam String itemCode){
        return new ResponseEntity<>(sItemSAP.getItemSAPByItemCode(itemCode,"ALPC"),HttpStatus.OK);
    }

}
