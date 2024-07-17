package com.app.SpringJPA.entities7;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //crea un constructor sin atributos esto lo hace lombook
@AllArgsConstructor //crea un cosntructor con todos los atributos esto lo hace lombook
@Data //crea get y setter esto lo hace lombook
@Entity
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name="alumno_curso",
			joinColumns=@JoinColumn(name="alumno_id"),
			inverseJoinColumns=@JoinColumn(name="curso_id")
			)
	private Set<Curso> cursos= new HashSet<>() ;

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

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public Alumno(Long id, String nombre, Set<Curso> cursos) {
		super();
		Id = id;
		this.nombre = nombre;
		this.cursos = cursos;
	}
	public Alumno() {

	}

}
