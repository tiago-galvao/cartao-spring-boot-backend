package com.mastertech.cartao.cartao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST , reason = "Cartão já existente com esse número")
public class CartaoAlreadyExistsException extends RuntimeException {}
