package com.mastertech.cartao.cartao.service;

import java.util.Optional;

import com.mastertech.cartao.cartao.exception.CartaoAlreadyExistsException;
import com.mastertech.cartao.cartao.exception.CartaoNotFoundException;
import com.mastertech.cartao.cartao.model.Cartao;
import com.mastertech.cartao.cartao.repository.CartaoRepository;
import com.mastertech.cartao.cliente.model.Cliente;
import com.mastertech.cartao.cliente.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {
    
    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    ClienteService clienteService;

    public Cartao create(Cartao cartao) {
        
        Cliente cliente = clienteService.getById(cartao.getCliente().getId());
        cartao.setCliente(cliente);

        Optional<Cartao> byNumero = cartaoRepository.findByNumero(cartao.getNumero());

        if(byNumero.isPresent()) {
            throw new CartaoAlreadyExistsException();
        }

        cartao.setAtivo(false);

        return cartaoRepository.save(cartao);
    }

    public Cartao update(Cartao updatedCartao) {
        Cartao databaseCartao = getByNumero(updatedCartao.getNumero());

        databaseCartao.setAtivo(updatedCartao.getAtivo());

        return cartaoRepository.save(databaseCartao);
    }

    public Cartao getById(Long id) {
        Optional<Cartao> byId = cartaoRepository.findById(id);

        if(!byId.isPresent()) {
            throw new CartaoNotFoundException();
        }

        return byId.get();
    }

    public Cartao getByNumero(String numero) {
        Optional<Cartao> byId = cartaoRepository.findByNumero(numero);

        if(!byId.isPresent()) {
            throw new CartaoNotFoundException();
        }

        return byId.get();
    }

}