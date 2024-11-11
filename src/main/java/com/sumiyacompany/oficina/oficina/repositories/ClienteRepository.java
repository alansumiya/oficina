package com.sumiyacompany.oficina.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumiyacompany.oficina.oficina.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
