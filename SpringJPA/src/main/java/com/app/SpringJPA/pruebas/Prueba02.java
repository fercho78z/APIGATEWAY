package com.app.SpringJPA.pruebas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.SpringJPA.entities2.Autor;
import com.app.SpringJPA.entities2.Libro;
import com.app.SpringJPA.repository2.AutorRepository;
import com.app.SpringJPA.repository2.LibroRepository;

//@Component
public class Prueba02 implements CommandLineRunner{
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LibroRepository LibroRepository;

	@Override
	public void run(String... args) throws Exception {

	Autor autor = new Autor();
	autor.setNombre("Luis");
	
	Libro libro1 = new Libro();
	libro1.setTitulo("Principito");

	Libro libro2 = new Libro();
	libro2.setTitulo("Principito2");

	autor.getLibros().add(libro1);
	autor.getLibros().add(libro2);
	
	
	//guarada el autor y en automayicamente se gurda el libro por el cascade
	autorRepository.save(autor);
	
	Optional<Autor> autorGuardado = autorRepository.findById(autor.getId());
	autorGuardado.ifPresent( a -> {
		
		System.out.println("Autor por id: " + a.getNombre());
		autorRepository.save(a);
		System.out.println("Autor actualizado: " + a.getNombre());
		
	});
	
	List<Autor> autores = autorRepository.findAll();
	System.out.println("Lista de autores: " );
	for(Autor a:autores) {
		System.out.println("-"+a.getNombre());
		
	}
	//autorRepository.delete(autor);
	//System.out.println("autor eliminado");
	}
	
	
	
}