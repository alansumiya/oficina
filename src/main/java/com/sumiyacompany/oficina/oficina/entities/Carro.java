package com.sumiyacompany.oficina.oficina.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carro", schema = "public")
public class Carro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarro;
	private String nome;
	private String modelo;
	
	@OneToOne(mappedBy = "carro", cascade = CascadeType.ALL)
	private Cliente clienteCarro;
	
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marcaCarro;
	
	@ManyToMany
	@JoinTable(name = "tb_carro_cor",
	joinColumns = @JoinColumn(name = "id_carro"),
	inverseJoinColumns = @JoinColumn(name = "id_cor"))
	private Set<Cor> cores = new HashSet<>();
	
	public Carro() {
		
	}

	
	public Carro(Long idCarro, String nome, String modelo, Cliente clienteCarro, Marca marcaCarro) {
		super();
		this.idCarro = idCarro;
		this.nome = nome;
		this.modelo = modelo;
		this.clienteCarro = clienteCarro;
		this.marcaCarro = marcaCarro;
	}



	public Long getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

	public Cliente getClienteCarro() {
		return clienteCarro;
	}


	public void setClienteCarro(Cliente clienteCarro) {
		this.clienteCarro = clienteCarro;
	}


	public Marca getMarcaCarro() {
		return marcaCarro;
	}


	public void setMarcaCarro(Marca marcaCarro) {
		this.marcaCarro = marcaCarro;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idCarro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(idCarro, other.idCarro);
	}
	
	
	
}

