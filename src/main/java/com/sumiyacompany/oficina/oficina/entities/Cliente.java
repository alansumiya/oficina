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
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	private String nome;
	private String endereco;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Telefone> telefone = new ArrayList<>();
	
	@JsonIgnore
	@MapsId
	@OneToOne
	private Carro carro;
	
	
	public Cliente() {
		
	}
	

	public Cliente(Long idCliente, String nome, String endereco, List<Telefone> telefone, Carro carro) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.carro = carro;
	}


	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Carro getCarro() {
		return carro;
	}


	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	public List<Telefone> getTelefone() {
		return telefone;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}
	
	
	
	
	
}
