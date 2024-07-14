package com.app.SpringJPA.pruebas;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.SpringJPA.entities2.Autor;
import com.app.SpringJPA.entities3.Editor;
import com.app.SpringJPA.entities3.Revistas;
import com.app.SpringJPA.repository3.EditorRepository;
import com.app.SpringJPA.repository3.RevistasRepository;

//@Component
public class Prueba03 implements CommandLineRunner{
	@Autowired
	private EditorRepository editorRepository;
	@Autowired
	private RevistasRepository revistasRepository;

	@Override
	public void run(String... args) throws Exception {

	Editor editor= new Editor();
	editor.setNombre("Editorial Z");
	
	Revistas revista1 = new Revistas();
	revista1.setNombre("TvNotas");
	revista1.setEditor(editor);
	
	Revistas revista2 = new Revistas();
	revista2.setNombre("Planetas");
	revista2.setEditor(editor);
	
	editor.getRevistas().add(revista1);
	editor.getRevistas().add(revista2);
	
	
	//guarda el autor y en automayicamente se gurda el libro por el cascade
	editorRepository.save(editor);

	Optional<Editor> editorGuardado = editorRepository.findById(editor.getId());
	if(editorGuardado.isPresent()) {
		Editor editorObtenido = editorGuardado.get();
		System.out.println("Editor obtenido: " + editorObtenido.getNombre());
		editorObtenido.getRevistas().size();
		//Actualizar Nombre
		editorObtenido.setNombre("Editor ABC");
		editorRepository.save(editorObtenido);
		System.out.println("Editor actualizado: " + editorObtenido.getNombre());
		
		//crear  una nueva revista
		Revistas revista3 = new Revistas();
		revista3.setNombre("Planetas C");
		revista3.setEditor(editorObtenido);
		revistasRepository.save(revista3);
		System.out.println("Revista Creada: " + revista3.getNombre());
		
		
	}
	
	Optional<Revistas> revistaOptional= revistasRepository.findById(revista1.getId());
	if(revistaOptional.isPresent()) {
		Revistas revistaEliminar= revistaOptional.get();
		revistasRepository.delete(revistaEliminar);
		System.out.println("Revsita Eliminada"+ revistaEliminar.getNombre());
		
	}
	else {
		System.out.println("Revista no encontrada");
		
	}
	
	//editorRepository.delete(editor);
	//System.out.println("editor eliminado");
	
	
	}
}
