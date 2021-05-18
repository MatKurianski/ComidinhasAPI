package com.kurianski.comidinhas.adapter.datastore.mapper;

import com.kurianski.comidinhas.adapter.datastore.entity.CategoriaEntity;
import com.kurianski.comidinhas.domain.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaEntityToCategoriaMapper implements EntityMapper<CategoriaEntity, Categoria> {

    @Override
    public Categoria map(CategoriaEntity categoriaEntity) {
        return Categoria.builder()
                .nome(categoriaEntity.getNome())
                .descricao(categoriaEntity.getDescricao())
                .build();
    }
}
