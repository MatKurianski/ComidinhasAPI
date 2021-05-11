package com.kurianski.comidinhas.adapter.datastore;

import com.kurianski.comidinhas.domain.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    Optional<Categoria> pegarCategoriaPeloNome(String nomeCategoria);
    List<Categoria> pegarVariasCategoriasPeloNome(List<String> variosNomesCategorias);
    List<Categoria> pegarTodasCategorias();

}
