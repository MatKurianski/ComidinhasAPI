package com.kurianski.comidinhas.adapter.controller.mapper.response;

import com.kurianski.comidinhas.adapter.controller.entity.request.AdicionarProdutoRequest;
import com.kurianski.comidinhas.domain.entity.comando.ComandoAdicionarProduto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdicionarProdutoRequestToComandoAdicionarProdutoMapper {
    AdicionarProdutoRequestToComandoAdicionarProdutoMapper INSTANCE = Mappers.getMapper(AdicionarProdutoRequestToComandoAdicionarProdutoMapper.class);

    ComandoAdicionarProduto map(AdicionarProdutoRequest cap);
}
