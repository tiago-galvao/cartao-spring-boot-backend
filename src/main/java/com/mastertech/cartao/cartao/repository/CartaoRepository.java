package com.mastertech.cartao.cartao.repository;

import java.util.Optional;
import com.mastertech.cartao.cartao.model.Cartao;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, Long> {

    Optional<Cartao> findByNumero(String numero);

}

