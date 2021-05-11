package com.kurianski.comidinhas.application.usecase.produtos;

import com.kurianski.comidinhas.adapter.datastore.ProdutoRepository;
import com.kurianski.comidinhas.domain.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PegarProdutoUseCase {
    private final ProdutoRepository produtoRepository;

    public Optional<Produto> pegar(UUID uuid) {
        return produtoRepository.pegarProdutoPorId(uuid);
    }
}
