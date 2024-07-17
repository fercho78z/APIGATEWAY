package com.app.SpringJPA.pruebas;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.SpringJPA.entities7.Alumno;
import com.app.SpringJPA.entities7.Curso;
import com.app.SpringJPA.repository7.AlumnoRepository;
import com.app.SpringJPA.repository7.CursoReposit;

import jakarta.transaction.Transactional;


@Component
public class Prueba07 implements CommandLineRunner {

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private CursoReposit cursoReposit;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		

	Alumno alumno1=new Alumno();
	alumno1.setNombre("Juan");

	Alumno alumno2=new Alumno();
	alumno2.setNombre("Ana");
	
	Curso curso1= new Curso();
	curso1.setNombre("Spring");
	
	Curso curso2= new Curso();
	curso2.setNombre("PHP");
	
	alumno1.getCursos().add(curso1);
	alumno1.getCursos().add(curso2);
	alumno2.getCursos().add(curso1);
	alumno2.getCursos().add(curso2);
	
	alumnoRepository.save(alumno1);
	alumnoRepository.save(alumno2);
	
	//Busqueda
	Alumno alumnoRecuperado=alumnoRepository.findById(alumno1.getId()).orElse(alumno1);
	System.out.println("Alumno Recuperado: " + alumnoRecuperado.getNombre());
	
	Curso cursoRecuperado= cursoReposit.findById(curso1.getId()).orElse(null);
	System.out.println("Curso recuperado: " + cursoRecuperado.getNombre());
	
	alumnoRepository.deleteById(alumno1.getId());
	cursoReposit.deleteById(curso1.getId());
	
	}
}
