package com.mastertech.cartao.cartao.model.dto.get;

import lombok.Getter;
import lombok.Setter;

public class GetCartaoResponse {
    
    @Getter @Setter private Long id;
    @Getter @Setter private String numero;
    @Getter @Setter private Long clienteId;

}