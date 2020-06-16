package com.mastertech.cartao.cliente.repository;

import com.mastertech.cartao.cliente.model.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}