package com.kurianski.comidinhas.adapter.controller.entity.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
public class AdicionarProdutoRequest {
    @NotNull
    private String nome;
    @NotNull
    private String urlImagem;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private String descricao;
    @NotNull
    private List<String> nomesCategorias;
}
