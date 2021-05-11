package com.kurianski.comidinhas.adapter.datastore;

import com.kurianski.comidinhas.domain.entity.Categoria;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {
    private final Map<String, Categoria> categorias = Map.ofEntries(
            Map.entry("salgado", Categoria.builder().nome("salgado").descricao("Comidinhas salgadas").build()),
            Map.entry("doce", Categoria.builder().nome("salgado").descricao("Comidinhas doces").build())
    );

    @Override
    public Optional<Categoria> pegarCategoriaPeloNome(String nomeCategoria) {
        return Optional.ofNullable(this.categorias.get(nomeCategoria));
    }

    @Override
    public List<Categoria> pegarVariasCategoriasPeloNome(List<String> variosNomesCategorias) {
        return variosNomesCategorias.stream().map(categorias::get).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public List<Categoria> pegarTodasCategorias() {
        return new ArrayList<>(categorias.values());
    }
}
