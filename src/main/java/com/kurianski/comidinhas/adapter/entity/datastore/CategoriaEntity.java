package com.kurianski.comidinhas.adapter.entity.datastore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaEntity {
    String nome;
    String descricao;
}
