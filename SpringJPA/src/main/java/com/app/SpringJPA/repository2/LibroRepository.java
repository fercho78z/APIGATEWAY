package com.app.SpringJPA.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SpringJPA.entities2.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{

}
