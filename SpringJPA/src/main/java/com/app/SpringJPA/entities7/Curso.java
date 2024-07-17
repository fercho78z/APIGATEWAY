package com.app.SpringJPA.entities7;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //crea un constructor sin atributos esto lo hace lombook
@AllArgsConstructor //crea un cosntructor con todos los atributos esto lo hace lombook
@Data //crea get y setter esto lo hace lombook
@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	@ManyToMany(mappedBy="cursos")
	private Set<Alumno> alumnos=new HashSet<>();
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
	public Set<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public Curso(Long id, String nombre, Set<Alumno> alumnos) {
		super();
		Id = id;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	public Curso() {

	}

	
	
}
