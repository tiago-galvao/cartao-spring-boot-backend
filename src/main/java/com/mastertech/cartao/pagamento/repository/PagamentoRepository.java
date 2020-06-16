package com.mastertech.cartao.pagamento.repository;

import java.util.List;

import com.mastertech.cartao.pagamento.model.Pagamento;

import org.springframework.data.repository.CrudRepository;

public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {

    List<Pagamento> findAllByCartao_id(Long cartao_id);

}
