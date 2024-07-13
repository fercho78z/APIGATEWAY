package com.app.SpringJPA.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SpringJPA.entities.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Long>{

}
