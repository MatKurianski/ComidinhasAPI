package com.kurianski.comidinhas.adapter.datastore.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaEntity {
    String nome;
    String descricao;
}
