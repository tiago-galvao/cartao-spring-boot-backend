package com.mastertech.cartao.pagamento.controller;

import java.util.List;

import com.mastertech.cartao.pagamento.model.Pagamento;
import com.mastertech.cartao.pagamento.model.dto.CreatePagamentoRequest;
import com.mastertech.cartao.pagamento.model.dto.PagamentoResponse;
import com.mastertech.cartao.pagamento.model.mapper.PagamentoMapper;
import com.mastertech.cartao.pagamento.service.PagamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/pagamento")
    public PagamentoResponse create(@RequestBody CreatePagamentoRequest createPagamentoRequest) {
        Pagamento pagamento = PagamentoMapper.toPagamento(createPagamentoRequest);

        pagamento = pagamentoService.create(pagamento);

        return PagamentoMapper.toPagamentoResponse(pagamento);
    }

    @GetMapping("/pagamentos/{cartaoId}")
    public List<PagamentoResponse> listByCartao(@PathVariable Long cartaoId) {
        List<Pagamento> pagamentos = pagamentoService.listByCartao(cartaoId);
        return PagamentoMapper.toPagamentoResponse(pagamentos);
    }
}
