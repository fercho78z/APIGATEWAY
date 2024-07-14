package com.app.SpringJPA.entities3;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



/*@NoArgsConstructor(force=true) //crea un constructor sin atributos esto lo hace lombook
@AllArgsConstructor //crea un cosntructor con todos los atributos esto lo hace lombook
@Data //crea get y setter esto lo hace lombook
*/
@Entity
@Table(name="editor")
public class Editor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	
	@OneToMany(mappedBy="editor", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Revistas> revistas = new ArrayList<>();

	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public List<Revistas> getRevistas() {
		return revistas;
	}
	public void setRevistas(List<Revistas> revistas) {
		this.revistas = revistas;
	}
	
	@Override
	public String toString() {
		return "Editor [Id=" + Id + ", nombre=" + nombre + ", revistas=" + revistas + "]";
	}
	
	public Editor() {
	}	
	
	public Editor(Long id, String nombre, List<Revistas> libros) {
		super();
		Id = id;
		this.nombre = nombre;
		this.revistas = libros;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
