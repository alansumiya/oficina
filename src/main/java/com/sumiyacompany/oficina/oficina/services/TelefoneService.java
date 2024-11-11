package com.sumiyacompany.oficina.oficina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.sumiyacompany.oficina.oficina.entities.Telefone;
import com.sumiyacompany.oficina.oficina.repositories.TelefoneRepository;
import com.sumiyacompany.oficina.oficina.services.exceptions.DataBaseException;
import com.sumiyacompany.oficina.oficina.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

public class TelefoneService {
	@Autowired
	private TelefoneRepository repository;
	
	public List<Telefone> findAll(){
		return repository.findAll();
	}
	
	public Telefone findById(Long id) {
		Optional<Telefone> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Telefone insert(Telefone obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Optional<Telefone> telefone = repository.findById(id);
		if(telefone.isPresent()) {
			try {
				repository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataBaseException(e.getMessage());
			}
		} else {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Telefone update(Long id, Telefone obj) {
		try {
			Telefone entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Telefone entity, Telefone obj) {
		entity.setTipoNum(obj.getTipoNum());
		entity.setNumero(obj.getNumero());
	}
}