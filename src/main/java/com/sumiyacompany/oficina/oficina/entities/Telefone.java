package com.sumiyacompany.oficina.oficina.entities;

import java.io.Serializable;
import java.util.Objects;

import com.sumiyacompany.oficina.oficina.entities.enums.TipoNum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Telefone", schema = "public")
public class Telefone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;
	private Integer tipoNum;
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")  //nome da coluna que vai fazer a associação do telefone
	//com o cliente através de uma tabela a parte
	private Cliente cliente;
	
	
	public Telefone() {
		
	}

	

	public Telefone(Long idTelefone, TipoNum tipoNum, String numero, Cliente cliente) {
		super();
		this.idTelefone = idTelefone;
		setTipoNum(tipoNum);
		this.numero = numero;
		this.cliente = cliente;
	}



	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public TipoNum getTipoNum() {
		return TipoNum.valueOf(tipoNum);
	}

	public void setTipoNum(TipoNum tipoNum) {
		if(tipoNum != null)
		this.tipoNum = tipoNum.getCode();
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
