package com.app.SpringJPA.entities2;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //crea un constructor sin atributos esto lo hace lombook
@AllArgsConstructor //crea un cosntructor con todos los atributos esto lo hace lombook
@Data //crea get y setter esto lo hace lombook
@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String titulo;
	
	public Libro() {

	}
	
	@Override
	public String toString() {
		return "Libro [Id=" + Id + ", titulo=" + titulo + "]";
	}

	public Libro(Long id, String titulo) {
		super();
		Id = id;
		this.titulo = titulo;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
