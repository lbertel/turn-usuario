package io.lbertel.turn.app.cliente.models.services;


import io.lbertel.turn.app.cliente.models.entity.Alumno;

import java.util.Optional;

public interface AlumnoService {

    Iterable<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    void deleteById(Long id);

}
