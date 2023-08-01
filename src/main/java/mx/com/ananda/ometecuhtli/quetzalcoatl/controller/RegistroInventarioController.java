package mx.com.ananda.ometecuhtli.quetzalcoatl.controller;

import mx.com.ananda.ometecuhtli.quetzalcoatl.model.entity.RegistrosInventarioModel;
import mx.com.ananda.ometecuhtli.quetzalcoatl.service.interfaces.IRegistroInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("ananda/ometecuhtli/quetzalcoatl/registros")
@RestController
public class RegistroInventarioController {

    @Autowired
    private IRegistroInventarioService sRegistros;

    @GetMapping
    public ResponseEntity<?> listarRegistros(){
        return new ResponseEntity<>(sRegistros.listRegistros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerRegistriById(@PathVariable Long id){
        return new ResponseEntity<>(sRegistros.getRegistroById(id),HttpStatus.OK);
    }

    @GetMapping("/itemCode")
    public ResponseEntity<?> obtenerRegistroByItemCode(@RequestParam String itemCode){
        return new ResponseEntity<>(sRegistros.getRegistroByItemCode(itemCode),HttpStatus.OK);
    }

    @GetMapping("/equipo")
    public ResponseEntity<?> obtenerRegistrosByEquipo(@RequestParam String equipo){
        return new ResponseEntity<>(sRegistros.listRegistrosByEquipo(equipo),HttpStatus.OK);
    }

    @GetMapping("/ronda")
    public ResponseEntity<?> obetnerRegistrosByRonda(@RequestParam String ronda){
        return new ResponseEntity<>(sRegistros.listRegistrosByRonda(Integer.parseInt(ronda)),HttpStatus.OK);
    }

    @GetMapping("/ubicacion")
    public ResponseEntity<?> obtenerRegistrosByUbicacion(@RequestParam String ubicacion){
        return new ResponseEntity<>(sRegistros.listRegistroByUbicacion(ubicacion),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarRegistro(@RequestBody RegistrosInventarioModel registro){
        return new ResponseEntity<>(sRegistros.saveRegistro(registro),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> actualizarRegistro(@RequestBody RegistrosInventarioModel registro){
        sRegistros.updateRegistro(registro);
        return new ResponseEntity<>("Registro Actualizado",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarRegistro(@PathVariable Long id){
        sRegistros.deleteRegistroById(id);
        return new ResponseEntity<>("Registro Borrado",HttpStatus.NO_CONTENT);
    }
}
