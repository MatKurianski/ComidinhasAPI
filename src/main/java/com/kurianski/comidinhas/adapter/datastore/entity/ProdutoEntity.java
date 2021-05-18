package com.kurianski.comidinhas.adapter.datastore.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ProdutoEntity {
    private UUID id;
    private String nome;
    private String urlImagem;
    private BigDecimal valor;
    private String descricao;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAtualizacao;
    private UsuarioEntity vendedor;
    private List<CategoriaEntity> categorias;
}
