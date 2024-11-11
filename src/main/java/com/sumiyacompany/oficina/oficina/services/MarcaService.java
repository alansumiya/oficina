package com.sumiyacompany.oficina.oficina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.sumiyacompany.oficina.oficina.entities.Marca;
import com.sumiyacompany.oficina.oficina.repositories.MarcaRepository;
import com.sumiyacompany.oficina.oficina.services.exceptions.DataBaseException;
import com.sumiyacompany.oficina.oficina.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

public class MarcaService {
	@Autowired
	private MarcaRepository repository;
	
	public List<Marca> findAll(){
		return repository.findAll();
	}
	
	public Marca findById(Long id) {
		Optional<Marca> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Marca insert(Marca obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Optional<Marca> marca = repository.findById(id);
		if(marca.isPresent()) {
			try {
				repository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataBaseException(e.getMessage());
			}
		} else {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Marca update(Long id, Marca obj) {
		try {
			Marca entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Marca entity, Marca obj) {
		entity.setMarca(obj.getMarca());
		
	}
}