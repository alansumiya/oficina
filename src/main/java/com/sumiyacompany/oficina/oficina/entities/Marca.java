package com.sumiyacompany.oficina.oficina.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Marca")
public class Marca implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarca;
	private String marca;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marcaCarro")
	private List<Carro> carroMarca = new ArrayList<>();
	
	public Marca() {
		
	}

	
	public Marca(Long idMarca, String marca, List<Carro> carroMarca) {
		super();
		this.idMarca = idMarca;
		this.marca = marca;
		this.carroMarca = carroMarca;
	}


	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	

	public List<Carro> getCarroMarca() {
		return carroMarca;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idMarca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		return Objects.equals(idMarca, other.idMarca);
	}
	
	
	
}
