package com.app.SpringJPA.repository6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SpringJPA.entities6.Vuelo;
@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

}
