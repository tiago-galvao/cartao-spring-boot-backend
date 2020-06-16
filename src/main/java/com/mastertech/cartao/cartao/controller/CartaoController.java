package com.mastertech.cartao.cartao.controller;

import com.mastertech.cartao.cartao.model.Cartao;
import com.mastertech.cartao.cartao.model.dto.create.CreateCartaoRequest;
import com.mastertech.cartao.cartao.model.dto.create.CreateCartaoResponse;
import com.mastertech.cartao.cartao.model.dto.get.GetCartaoResponse;
import com.mastertech.cartao.cartao.model.dto.update.UpdateCartaoRequest;
import com.mastertech.cartao.cartao.model.dto.update.UpdateCartaoResponse;
import com.mastertech.cartao.cartao.model.mapper.CartaoMapper;
import com.mastertech.cartao.cartao.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCartaoResponse create(@RequestBody CreateCartaoRequest createCartaoRequest) {

        Cartao cartao = CartaoMapper.fromCreateRequest(createCartaoRequest);

        cartao = cartaoService.create(cartao);

        return CartaoMapper.toCreateResponse(cartao);
    }

    @PatchMapping("/{numero}")
    public UpdateCartaoResponse update(@PathVariable String numero, @RequestBody UpdateCartaoRequest updateCartaoRequest) {

        Cartao cartao = CartaoMapper.fromUpdateRequest(updateCartaoRequest);
        cartao.setNumero(numero);

        cartao = cartaoService.update(cartao);
        return CartaoMapper.toUpdateResponse(cartao);
    }

    @GetMapping("/{numero}")
    public GetCartaoResponse getByNumero(@PathVariable String numero) {
        Cartao byNumero = cartaoService.getByNumero(numero);

        return CartaoMapper.toGetResponse(byNumero);
    }

}
