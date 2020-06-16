package com.mastertech.cartao.pagamento.model.mapper;

import java.util.ArrayList;
import java.util.List;

import com.mastertech.cartao.cartao.model.Cartao;
import com.mastertech.cartao.pagamento.model.Pagamento;
import com.mastertech.cartao.pagamento.model.dto.CreatePagamentoRequest;
import com.mastertech.cartao.pagamento.model.dto.PagamentoResponse;

public class PagamentoMapper {

    public static PagamentoResponse toPagamentoResponse(Pagamento pagamento) {
        PagamentoResponse pagamentoResponse = new PagamentoResponse();

        pagamentoResponse.setId(pagamento.getId());
        pagamentoResponse.setCartaoId(pagamento.getCartao().getId());
        pagamentoResponse.setDescricao(pagamento.getDescricao());
        pagamentoResponse.setValor(pagamento.getValor());

        return pagamentoResponse;
    }

    public static List<PagamentoResponse> toPagamentoResponse(List<Pagamento> pagamentos) {
        List<PagamentoResponse> pagamentoResponses = new ArrayList<>();

        for (Pagamento pagamento : pagamentos) {
            pagamentoResponses.add(toPagamentoResponse(pagamento));
        }

        return pagamentoResponses;
    }

    public static Pagamento toPagamento(CreatePagamentoRequest createPagamentoRequest) {
        Cartao cartao = new Cartao();
        cartao.setId(createPagamentoRequest.getCartaoId());

        Pagamento pagamento = new Pagamento();

        pagamento.setDescricao(createPagamentoRequest.getDescricao());
        pagamento.setValor(createPagamentoRequest.getValor());
        pagamento.setCartao(cartao);

        return pagamento;
    }

    
}