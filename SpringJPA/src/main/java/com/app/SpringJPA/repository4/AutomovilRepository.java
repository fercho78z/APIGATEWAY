package com.app.SpringJPA.repository4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SpringJPA.entities4.Automovil;

@Repository
public interface AutomovilRepository extends JpaRepository<Automovil,Long>{

}
