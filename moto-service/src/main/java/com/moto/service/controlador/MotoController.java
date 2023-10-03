package com.moto.service.controlador;

import com.moto.service.entidades.Moto;
import com.moto.service.servicio.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {
    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> listaMotos(){
        List<Moto> motos = motoService.getAll();
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id){
        Moto moto = motoService.getMotoById(id);
        if(moto == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PostMapping
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
        Moto motoNuevo = motoService.save(moto);
        return ResponseEntity.ok(motoNuevo);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listaMotoPorUsuario(@PathVariable int usuarioId){
        List<Moto> motos = motoService.byUsuarioId(usuarioId);
        if(motos == null){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
}
