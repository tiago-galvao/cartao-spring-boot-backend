package com.mastertech.cartao.cartao.model.dto.create;

import lombok.Getter;
import lombok.Setter;

public class CreateCartaoResponse {
    
    @Getter @Setter private Long id;
    @Getter @Setter private String numero;
    @Getter @Setter private Long clienteId;
    @Getter @Setter private Boolean ativo;

}