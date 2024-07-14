package com.app.SpringJPA.entities2;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //crea un constructor sin atributos esto lo hace lombook
@AllArgsConstructor //crea un cosntructor con todos los atributos esto lo hace lombook
@Data //crea get y setter esto lo hace lombook
@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "autor_id")
	private List<Libro> libros = new ArrayList<>();
	
	public Autor() {

	}
	
	
	@Override
	public String toString() {
		return "Autor [Id=" + Id + ", nombre=" + nombre + ", libros=" + libros + "]";
	}


	public Autor(Long id, String nombre, List<Libro> libros) {
		super();
		Id = id;
		this.nombre = nombre;
		this.libros = libros;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}


	
	
	
	
	
	
}
