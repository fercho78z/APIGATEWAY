package com.app.SpringJPA.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.SpringJPA.entities4.Automovil;
import com.app.SpringJPA.entities4.Propietario;
import com.app.SpringJPA.repository4.AutomovilRepository;
import com.app.SpringJPA.repository4.PropietarioRepository;


	@Component
	public class Prueba04 implements CommandLineRunner{
		@Autowired
		private PropietarioRepository propietarioRepository;
		@Autowired
		private AutomovilRepository automovilRepository;

		@Override
		public void run(String... args) throws Exception {

			Propietario propietario=new Propietario();
			propietario.setNombre("Juanito");
			
			Automovil auto= new Automovil();
			auto.setMarca("Toyota");
			auto.setModelo("Camrry");
			auto.setPropietario(propietario);
			propietario.setAutomovil(auto);
			
			propietarioRepository.save(propietario);
			automovilRepository.save(auto);
			//Leer propieatrio
			Long propietarioId=propietario.getId();
			Propietario pActual = propietarioRepository.findById(propietarioId).orElse(null);
			if(pActual!=null) {
				System.out.println("Propieatrio Actual: " + pActual.getNombre());
			}
			//Actualizar automovil asociado al propieatrio
			Automovil autoUpdate=propietario.getAutomovil();
			autoUpdate.setMarca("Honda");
			autoUpdate.setModelo("Accord");
			automovilRepository.save(autoUpdate);
			//Eliminar propietario y automovil
			//propietarioRepository.delete(propietario);
			
			//VErificar si se elimino propietario
			
			Propietario propietarioDelete = propietarioRepository.findById(propietarioId).orElse(null);
			if(propietarioDelete==null) {
				System.out.println("Propietario eliminado con exito!!");
			}
			
		}
	}
