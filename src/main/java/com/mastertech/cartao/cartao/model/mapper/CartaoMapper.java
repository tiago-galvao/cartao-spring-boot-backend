package com.mastertech.cartao.cartao.model.mapper;

import com.mastertech.cartao.cartao.model.Cartao;
import com.mastertech.cartao.cartao.model.dto.create.CreateCartaoRequest;
import com.mastertech.cartao.cartao.model.dto.create.CreateCartaoResponse;
import com.mastertech.cartao.cartao.model.dto.get.GetCartaoResponse;
import com.mastertech.cartao.cartao.model.dto.update.UpdateCartaoRequest;
import com.mastertech.cartao.cartao.model.dto.update.UpdateCartaoResponse;
import com.mastertech.cartao.cliente.model.Cliente;

public class CartaoMapper {
    public static Cartao fromCreateRequest(CreateCartaoRequest cartaoCreateRequest) {
        Cliente cliente = new Cliente();
        cliente.setId(cartaoCreateRequest.getClienteId());

        Cartao cartao = new Cartao();
        cartao.setNumero(cartaoCreateRequest.getNumero());

        cartao.setCliente(cliente);
        return cartao;
    }

    public static CreateCartaoResponse toCreateResponse(Cartao cartao) {
        CreateCartaoResponse createCartaoResponse = new CreateCartaoResponse();

        createCartaoResponse.setId(cartao.getId());
        createCartaoResponse.setNumero(cartao.getNumero());
        createCartaoResponse.setClienteId(cartao.getCliente().getId());
        createCartaoResponse.setAtivo(cartao.getAtivo());

        return createCartaoResponse;
    }

    public static Cartao fromUpdateRequest(UpdateCartaoRequest updateCartaoRequest) {
        Cartao cartao = new Cartao();
        cartao.setAtivo(updateCartaoRequest.getAtivo());
        return cartao;
    }

    public static UpdateCartaoResponse toUpdateResponse(Cartao cartao) {
        UpdateCartaoResponse updateCartaoResponse = new UpdateCartaoResponse();

        updateCartaoResponse.setId(cartao.getId());
        updateCartaoResponse.setNumero(cartao.getNumero());
        updateCartaoResponse.setClienteId(cartao.getCliente().getId());
        updateCartaoResponse.setAtivo(cartao.getAtivo());

        return updateCartaoResponse;
    }

    public static GetCartaoResponse toGetResponse(Cartao cartao) {
        GetCartaoResponse getCartaoResponse = new GetCartaoResponse();

        getCartaoResponse.setId(cartao.getId());
        getCartaoResponse.setNumero(cartao.getNumero());
        getCartaoResponse.setClienteId(cartao.getCliente().getId());

        return getCartaoResponse;
    }


}