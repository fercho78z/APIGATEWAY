package com.app.SpringJPA.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //crea un constructor sin atributos esto lo hace lombook
@AllArgsConstructor //crea un cosntructor con todos los atributos esto lo hace lombook
@Data //crea get y setter esto lo hace lombook
@Entity
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String calle;
	private String ciudad;
	private String codigoPostal;
	
	public Direccion() {

	}
	
	@Override
	public String toString() {
		return "Direccion [Id=" + Id + ", calle=" + calle + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal
				+ "]";
	}
	public Direccion(Long id, String calle, String ciudad, String codigoPostal) {
		super();
		Id = id;
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


}
