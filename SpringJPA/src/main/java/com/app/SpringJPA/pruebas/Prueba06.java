package com.app.SpringJPA.pruebas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.SpringJPA.entities6.Aerolinea;
import com.app.SpringJPA.entities6.Vuelo;
import com.app.SpringJPA.repository4.PropietarioRepository;
import com.app.SpringJPA.repository6.AerolineaRepository;
import com.app.SpringJPA.repository6.VueloRepository;

@Component
public class Prueba06 implements CommandLineRunner {

	@Autowired
	private AerolineaRepository aerolineaRepository;
	@Autowired
	private VueloRepository vueloRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Aerolinea aero=new Aerolinea();
		aero.setNombre("Mexicana");
		
		Vuelo vuelo1=new Vuelo();
		vuelo1.setNumeroVuelo("1");
		vuelo1.setDestino("Japon");
		
		Vuelo vuelo2=new Vuelo();
		vuelo2.setNumeroVuelo("2");
		vuelo2.setDestino("Francia");
		aero.getVuelos().add(vuelo1);
		aero.getVuelos().add(vuelo2);
		
		aerolineaRepository.save(aero);
		
		//Leer aerolinea
		
		Aerolinea aerolineaActual = aerolineaRepository.findById(aero.getId()).orElse(null);
		System.out.println("Aeroliena Actual: " + aerolineaActual.getNombre());
		
		//Eliminar Aerolinea
		
		aerolineaRepository.delete(aerolineaActual);
		
		//Comprobar que se elimino la aerolinea
		
		List<Vuelo> vuelos = vueloRepository.findAll();
		System.out.println("Numeo de vuelos en la base de datos: " + vuelos.size());
		
		
		
		
	}
	
}
