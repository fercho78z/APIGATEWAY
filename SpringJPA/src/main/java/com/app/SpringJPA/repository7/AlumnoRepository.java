package com.app.SpringJPA.repository7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SpringJPA.entities7.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
