package com.sumiyacompany.oficina.oficina.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Telefone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;
	private Integer tipoNum;
	private String numero;
	
	
	
	
	public Telefone() {
		
	}

	public Telefone(Long idTelefone, Integer tipoNum, String numero) {
		super();
		this.idTelefone = idTelefone;
		this.tipoNum = tipoNum;
		this.numero = numero;
	}

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Integer getTipoNum() {
		return tipoNum;
	}

	public void setTipoNum(Integer tipoNum) {
		this.tipoNum = tipoNum;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTelefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(idTelefone, other.idTelefone);
	}
	
	
	
	
	
	
}
