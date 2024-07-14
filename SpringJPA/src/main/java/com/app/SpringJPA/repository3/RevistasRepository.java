package com.app.SpringJPA.repository3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SpringJPA.entities3.Revistas;

@Repository
public interface RevistasRepository extends JpaRepository<Revistas, Long>{

}
