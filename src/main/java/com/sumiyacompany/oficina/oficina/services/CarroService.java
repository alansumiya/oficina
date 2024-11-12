package com.sumiyacompany.oficina.oficina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sumiyacompany.oficina.oficina.entities.Carro;
import com.sumiyacompany.oficina.oficina.repositories.CarroRepository;
import com.sumiyacompany.oficina.oficina.services.exceptions.DataBaseException;
import com.sumiyacompany.oficina.oficina.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarroService {
	@Autowired
	private CarroRepository repository;
	
	public List<Carro> findAll(){
		return repository.findAll();
	}
	
	public Carro findById(Long id) {
		Optional<Carro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Carro insert(Carro obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Optional<Carro> carro = repository.findById(id);
		if(carro.isPresent()) {
			try {
				repository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataBaseException(e.getMessage());
			}
		} else {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Carro update(Long id, Carro obj) {
		try {
			Carro entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Carro entity, Carro obj) {
		entity.setNome(obj.getNome());
		entity.setModelo(obj.getModelo());
	}
}