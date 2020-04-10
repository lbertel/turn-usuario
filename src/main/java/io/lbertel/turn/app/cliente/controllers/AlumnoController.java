package io.lbertel.turn.app.cliente.controllers;

import io.lbertel.turn.app.cliente.models.entity.Alumno;
import io.lbertel.turn.app.cliente.models.services.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    private final AlumnoService service;

    @Autowired
    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){

        Optional<Alumno> optionalAlumno = service.findById(id);

        if(optionalAlumno.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optionalAlumno.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){
        Alumno alumnoDB = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> optionalAlumno = service.findById(id);

        if(optionalAlumno.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoDB = optionalAlumno.get();

        alumnoDB.setNombre(alumno.getNombre());
        alumnoDB.setApellido(alumno.getApellido());
        alumnoDB.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(alumnoDB) );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}

