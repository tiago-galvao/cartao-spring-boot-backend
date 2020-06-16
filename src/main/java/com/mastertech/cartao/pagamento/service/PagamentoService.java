package com.mastertech.cartao.pagamento.service;

import java.util.List;

import com.mastertech.cartao.cartao.model.Cartao;
import com.mastertech.cartao.cartao.service.CartaoService;
import com.mastertech.cartao.pagamento.model.Pagamento;
import com.mastertech.cartao.pagamento.repository.PagamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private CartaoService cartaoService;

    public Pagamento create(Pagamento pagamento) {
        Cartao cartao = cartaoService.getById(pagamento.getCartao().getId());

        pagamento.setCartao(cartao);

        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> listByCartao(Long cartaoId) {
        return pagamentoRepository.findAllByCartao_id(cartaoId);
    }

    
}