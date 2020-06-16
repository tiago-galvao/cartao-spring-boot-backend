package com.mastertech.cartao.cartao.model.dto.update;

import lombok.Getter;
import lombok.Setter;

public class UpdateCartaoResponse {
    
    @Getter @Setter private Long id;
    @Getter @Setter private String numero;
    @Getter @Setter private Long clienteId;
    @Getter @Setter private Boolean ativo;

}