package com.kurianski.comidinhas.application.usecase.produtos;

import com.kurianski.comidinhas.adapter.datastore.ProdutoRepository;
import com.kurianski.comidinhas.domain.entity.comando.ComandoAdicionarProduto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdicionarProdutoUseCase {
    private final ProdutoRepository produtoRepository;

    public void adicionar(ComandoAdicionarProduto comandoAdicionarProduto) {
        produtoRepository.adicionarProduto(comandoAdicionarProduto);
    }
}
