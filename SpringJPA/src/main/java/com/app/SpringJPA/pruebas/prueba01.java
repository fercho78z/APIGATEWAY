package com.app.SpringJPA.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.SpringJPA.entities.Direccion;
import com.app.SpringJPA.entities.Estudiante;
import com.app.SpringJPA.repository.DireccionRepository;
import com.app.SpringJPA.repository.EstudianteRepository;

//@Component
public class prueba01 implements CommandLineRunner{
	@Autowired
	private EstudianteRepository estudianteRepository;
	@Autowired
	private DireccionRepository direccionRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Direccion direccion = new Direccion();
		direccion.setCalle("999 Calle Principal");
		direccion.setCiudad("DF");
		direccion.setCodigoPostal("123456");
		//direccionRepository.save(direccion); si comento el save de diecccion debo en estudiante entity poner persist y sino 
		//lo comento en estudiante debo poner merge tambien es importante en application.properties poner update o create segun el caso
		
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Juan5");
		estudiante.setDireccion(direccion);
		estudianteRepository.save(estudiante);

		
		Direccion direccion2 = new Direccion();
		direccion2.setCalle("111 Principal");
		direccion2.setCiudad("DF");
		direccion2.setCodigoPostal("126");
		
		Estudiante estudiante2 = new Estudiante();
		estudianteRepository.save(estudiante2);
		estudiante2.setNombre("Juan7");
		estudiante.setDireccion(direccion);
		estudianteRepository.save(estudiante2);
		Iterable<Estudiante> estudiantes=estudianteRepository.findAll();
		for(Estudiante e:estudiantes) {
			System.out.println("Estudiante:"+e.getNombre()+" , Direccion: "+ e.getDireccion());
		}
		
		estudianteRepository.delete(estudiante2);
	} 

}