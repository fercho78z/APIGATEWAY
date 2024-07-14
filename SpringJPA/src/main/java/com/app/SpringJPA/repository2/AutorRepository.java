package com.app.SpringJPA.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SpringJPA.entities2.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
