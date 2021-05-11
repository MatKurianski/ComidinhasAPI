package com.kurianski.comidinhas.adapter.datastore;

import com.kurianski.comidinhas.domain.entity.Usuario;
import com.kurianski.comidinhas.domain.entity.comando.ComandoCadastrarUsuario;

import java.util.Optional;

public interface UsuarioRepository {
    void salvarUsuario(ComandoCadastrarUsuario usuario);
    Optional<Usuario> pegarUsuarioPorNomeUsuario(String nomeUsuario);
}
