package com.sumiyacompany.oficina.oficina.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Cor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCor;
	private String cor;
	
	public Cor() {
		
	}

	public Cor(Long idCor, String cor) {
		super();
		this.idCor = idCor;
		this.cor = cor;
	}

	public Long getIdCor() {
		return idCor;
	}

	public void setIdCor(Long idCor) {
		this.idCor = idCor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cor other = (Cor) obj;
		return Objects.equals(idCor, other.idCor);
	}
	
	
}
