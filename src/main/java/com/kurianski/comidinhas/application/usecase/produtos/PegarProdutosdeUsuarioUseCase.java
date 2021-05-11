package com.kurianski.comidinhas.application.usecase.produtos;

import com.kurianski.comidinhas.adapter.datastore.ProdutoRepository;
import com.kurianski.comidinhas.domain.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PegarProdutosdeUsuarioUseCase {
    private final ProdutoRepository produtoRepository;

    public List<Produto> pegar(String nomeUsuario) {
        return produtoRepository.pegarProdutoPorUsuario(nomeUsuario);
    }
}
