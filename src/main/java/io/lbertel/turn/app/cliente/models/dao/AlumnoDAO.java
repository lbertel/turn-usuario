package io.lbertel.turn.app.cliente.models.dao;

import io.lbertel.turn.app.cliente.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoDAO extends CrudRepository<Alumno, Long> {
}
