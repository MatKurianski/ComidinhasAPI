package com.kurianski.comidinhas.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Categoria {
    private String nome;
    private String descricao;
}
