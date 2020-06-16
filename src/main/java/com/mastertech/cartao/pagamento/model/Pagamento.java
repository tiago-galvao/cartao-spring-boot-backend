package com.mastertech.cartao.pagamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.mastertech.cartao.cartao.model.Cartao;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @ManyToOne
    @Getter @Setter private Cartao cartao;

    @Column
    @Getter @Setter private String descricao;

    @Column
    @Getter @Setter private Double valor;

}