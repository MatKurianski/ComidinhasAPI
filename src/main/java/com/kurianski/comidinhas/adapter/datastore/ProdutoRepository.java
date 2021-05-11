package com.kurianski.comidinhas.adapter.datastore;

import com.kurianski.comidinhas.domain.entity.Produto;
import com.kurianski.comidinhas.domain.entity.comando.ComandoAdicionarProduto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository {
    void adicionarProduto(ComandoAdicionarProduto produto);
    Optional<Produto> pegarProdutoPorId(UUID id);
    List<Produto> pegarProdutoPorUsuario(String nomeUsuario);
}
