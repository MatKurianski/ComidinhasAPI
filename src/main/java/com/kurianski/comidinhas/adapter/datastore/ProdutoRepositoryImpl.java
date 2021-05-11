package com.kurianski.comidinhas.adapter.datastore;

import com.kurianski.comidinhas.adapter.entity.datastore.CategoriaEntity;
import com.kurianski.comidinhas.adapter.entity.datastore.ProdutoEntity;
import com.kurianski.comidinhas.adapter.entity.datastore.UsuarioEntity;
import com.kurianski.comidinhas.adapter.entity.mapper.EntityMapper;
import com.kurianski.comidinhas.domain.entity.Produto;
import com.kurianski.comidinhas.domain.entity.comando.ComandoAdicionarProduto;
import com.kurianski.comidinhas.domain.exception.UsuarioNaoExisteException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProdutoRepositoryImpl implements ProdutoRepository {
    private final Map<UUID, ProdutoEntity> produtos = new HashMap<>();
    private final EntityMapper<ComandoAdicionarProduto, ProdutoEntity> produtoEntityMapper;
    private final EntityMapper<ProdutoEntity, Produto> produtoMapper;

    @Override
    public void adicionarProduto(ComandoAdicionarProduto produto) {
        ProdutoEntity produtoEntity = produtoEntityMapper.map(produto);
        this.produtos.put(produtoEntity.getId(), produtoEntity);
        System.out.println(produtos.values());
    }

    @Override
    public Optional<Produto> pegarProdutoPorId(UUID id) {
        return Optional.ofNullable(this.produtos.get(id)).map(produtoMapper::map);
    }

    @Override
    public List<Produto> pegarProdutoPorUsuario(String nomeUsuario) {
        return produtos.values().stream()
                .filter(produtoEntity -> produtoEntity.getVendedor().getNomeUsuario().equals(nomeUsuario))
                .map(produtoMapper::map)
                .collect(Collectors.toList());
    }
}
