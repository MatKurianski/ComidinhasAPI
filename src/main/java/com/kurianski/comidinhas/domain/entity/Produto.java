package com.kurianski.comidinhas.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Produto {
    private UUID id;
    private String nome;
    private String urlImagem;
    private BigDecimal valor;
    private String descricao;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAtualizacao;
    private Usuario vendedor;
    private List<Categoria> categorias;
}
