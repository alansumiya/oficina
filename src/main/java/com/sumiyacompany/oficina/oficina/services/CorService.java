package com.sumiyacompany.oficina.oficina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.sumiyacompany.oficina.oficina.entities.Cor;
import com.sumiyacompany.oficina.oficina.repositories.CorRepository;
import com.sumiyacompany.oficina.oficina.services.exceptions.DataBaseException;
import com.sumiyacompany.oficina.oficina.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

public class CorService {
	@Autowired
	private CorRepository repository;
	
	public List<Cor> findAll(){
		return repository.findAll();
	}
	
	public Cor findById(Long id) {
		Optional<Cor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cor insert(Cor obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Optional<Cor> cor = repository.findById(id);
		if(cor.isPresent()) {
			try {
				repository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataBaseException(e.getMessage());
			}
		} else {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Cor update(Long id, Cor obj) {
		try {
			Cor entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Cor entity, Cor obj) {
		entity.setCor(obj.getCor());
		
	}
}