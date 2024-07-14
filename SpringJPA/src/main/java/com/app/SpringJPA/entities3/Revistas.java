package com.app.SpringJPA.entities3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/*@NoArgsConstructor(force=true) //crea un constructor sin atributos esto lo hace lombook
@AllArgsConstructor(access=lombok.AccessLevel.PUBLIC) //crea un cosntructor con todos los atributos esto lo hace lombook
@Data //crea get y setters esto lo hace lombook
@Setter
@Getter
*/
@Entity
@Table(name="revistas")
public class Revistas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="editor_id")
	private Editor editor;
	
	public Revistas() {

	}
	
	public Revistas(Long id, String nombre, Editor editor) {
		super();
		Id = id;
		this.nombre = nombre;
		this.editor = editor;
	}

	@Override
	public String toString() {
		return "Revistas [Id=" + Id + ", nombre=" + nombre + ", editor=" + editor + "]";
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

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}


}
