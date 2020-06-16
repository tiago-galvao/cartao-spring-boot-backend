package com.mastertech.cartao.cartao.model.dto.create;

import lombok.Getter;
import lombok.Setter;

public class CreateCartaoRequest {

    @Getter @Setter private String numero;
    @Getter @Setter private Long clienteId;
    
}
