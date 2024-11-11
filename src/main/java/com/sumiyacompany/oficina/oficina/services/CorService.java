package com.sumiyacompany.oficina.oficina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.sumiyacompany.oficina.oficina.entities.Cliente;
import com.sumiyacompany.oficina.oficina.repositories.ClienteRepository;
import com.sumiyacompany.oficina.oficina.services.exceptions.DataBaseException;
import com.sumiyacompany.oficina.oficina.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

public class CorService {
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		if(cliente.isPresent()) {
			try {
				repository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataBaseException(e.getMessage());
			}
		} else {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Cliente update(Long id, Cliente obj) {
		try {
			Cliente entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setEndereco(obj.getEndereco());
	}
}