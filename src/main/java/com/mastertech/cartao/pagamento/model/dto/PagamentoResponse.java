package com.mastertech.cartao.pagamento.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class PagamentoResponse {

    @Getter @Setter private Long id;
    @Getter @Setter private String descricao;
    @Getter @Setter private Double valor;

    @JsonProperty("cartao_id")
    @Getter @Setter private Long cartaoId;

    
}