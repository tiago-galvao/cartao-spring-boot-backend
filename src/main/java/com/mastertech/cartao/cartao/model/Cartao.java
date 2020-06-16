package com.mastertech.cartao.cartao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.mastertech.cartao.cliente.model.Cliente;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column(unique = true)
    @Getter @Setter private String numero;

    @ManyToOne
    @Getter @Setter private Cliente cliente;

    @Column
    @Getter @Setter private Boolean ativo;

}
