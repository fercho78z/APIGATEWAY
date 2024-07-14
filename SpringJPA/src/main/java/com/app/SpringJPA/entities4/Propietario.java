package com.app.SpringJPA.entities4;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



/*@NoArgsConstructor(force=true) //crea un constructor sin atributos esto lo hace lombook
@AllArgsConstructor //crea un cosntructor con todos los atributos esto lo hace lombook
@Data //crea get y setter esto lo hace lombook
*/
@Entity
@Table(name="propietario")
public class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	
	@OneToOne(mappedBy="propietario", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Automovil automovil;

	@Override
	public String toString() {
		return "Propietario [Id=" + Id + ", nombre=" + nombre + ", automovil=" + automovil + "]";
	}

	public Propietario() {}
	
	public Propietario(Long id, String nombre, Automovil automovil) {
		super();
		Id = id;
		this.nombre = nombre;
		this.automovil = automovil;
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

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}





}
