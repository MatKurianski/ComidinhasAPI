package com.kurianski.comidinhas.adapter.entity.mapper;

import com.kurianski.comidinhas.adapter.datastore.CategoriaRepository;
import com.kurianski.comidinhas.adapter.datastore.UsuarioRepository;
import com.kurianski.comidinhas.adapter.entity.datastore.CategoriaEntity;
import com.kurianski.comidinhas.adapter.entity.datastore.ProdutoEntity;
import com.kurianski.comidinhas.adapter.entity.datastore.UsuarioEntity;
import com.kurianski.comidinhas.domain.entity.Categoria;
import com.kurianski.comidinhas.domain.entity.Produto;
import com.kurianski.comidinhas.domain.entity.Usuario;
import com.kurianski.comidinhas.domain.exception.UsuarioNaoExisteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProdutoEntityToProdutoMapper implements EntityMapper<ProdutoEntity, Produto> {
    private final EntityMapper<UsuarioEntity, Usuario> usuarioMapper;
    private final EntityMapper<CategoriaEntity, Categoria> categoriaMapper;

    private final CategoriaRepository categoriaRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Produto map(ProdutoEntity produtoEntity) {
        List<String> nomesCategorias = produtoEntity.getCategorias().stream().map(CategoriaEntity::getNome).collect(Collectors.toList());
        String nomeUsuario = produtoEntity.getVendedor().getNomeUsuario();

        return Produto.builder()
                .id(produtoEntity.getId())
                .nome(produtoEntity.getNome())
                .valor(produtoEntity.getValor())
                .vendedor(usuarioRepository.pegarUsuarioPorNomeUsuario(nomeUsuario)
                        .orElseThrow(() -> new UsuarioNaoExisteException("Usuário atrelado a produto não existe")))
                .categorias(categoriaRepository.pegarVariasCategoriasPeloNome(nomesCategorias))
                .dataCriacao(produtoEntity.getDataCriacao())
                .dataAtualizacao(produtoEntity.getDataAtualizacao())
                .descricao(produtoEntity.getDescricao())
                .urlImagem(produtoEntity.getUrlImagem())
                .build();
    }
}
