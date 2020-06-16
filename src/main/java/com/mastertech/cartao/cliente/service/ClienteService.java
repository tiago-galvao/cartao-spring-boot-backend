package com.mastertech.cartao.cliente.service;

import java.util.Optional;

import com.mastertech.cartao.cliente.exception.ClienteNotFoundException;
import com.mastertech.cartao.cliente.model.Cliente;
import com.mastertech.cartao.cliente.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente getById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(!cliente.isPresent()) {
            throw new ClienteNotFoundException();
        }

        return cliente.get();
    }

}