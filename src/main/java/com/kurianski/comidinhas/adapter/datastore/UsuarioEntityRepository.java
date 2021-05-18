package com.kurianski.comidinhas.adapter.datastore;

import com.kurianski.comidinhas.adapter.datastore.entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioEntityRepository {
    Optional<UsuarioEntity> pegarUsuarioEntityComSenhaPorNomeUsuario(String nomeUsuario);
    Optional<UsuarioEntity> pegarUsuarioEntityPorNomeUsuario(String nomeUsuario);
    void salvarUsuarioEntity(UsuarioEntity usuarioEntity);
}
