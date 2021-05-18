package com.kurianski.comidinhas.adapter.datastore.mapper;

import com.kurianski.comidinhas.adapter.datastore.entity.CategoriaEntity;
import com.kurianski.comidinhas.adapter.datastore.entity.ProdutoEntity;
import com.kurianski.comidinhas.adapter.datastore.entity.UsuarioEntity;
import com.kurianski.comidinhas.domain.entity.comando.ComandoAdicionarProduto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ComandoAdicionarProdutoToProdutoEntityMapper implements EntityMapper<ComandoAdicionarProduto, ProdutoEntity> {

    @Override
    public ProdutoEntity map(ComandoAdicionarProduto comandoAdicionarProduto) {
        OffsetDateTime dataHoraAtual = OffsetDateTime.now();

        return ProdutoEntity.builder()
                .id(UUID.randomUUID())
                .nome(comandoAdicionarProduto.getNome())
                .urlImagem(comandoAdicionarProduto.getUrlImagem())
                .descricao(comandoAdicionarProduto.getDescricao())
                .categorias(comandoAdicionarProduto.getNomesCategorias().stream().map( nomeCategoria ->
                        CategoriaEntity.builder().nome(nomeCategoria).build()
                ).collect(Collectors.toList()))
                .vendedor(
                        UsuarioEntity.builder().nomeUsuario(comandoAdicionarProduto.getNomeUsuarioVendedor()).build()
                )
                .valor(comandoAdicionarProduto.getValor())
                .dataCriacao(dataHoraAtual)
                .dataAtualizacao(dataHoraAtual)
                .build();
    }
}
