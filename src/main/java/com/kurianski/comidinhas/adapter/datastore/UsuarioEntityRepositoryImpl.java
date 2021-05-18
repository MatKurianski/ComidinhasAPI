package com.kurianski.comidinhas.adapter.datastore;

import com.kurianski.comidinhas.adapter.datastore.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioEntityRepositoryImpl implements UsuarioEntityRepository {
    private final Map<String, UsuarioEntity> usuarios = new HashMap<>();
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Optional<UsuarioEntity> pegarUsuarioEntityComSenhaPorNomeUsuario(String nomeUsuario) {
        return Optional.ofNullable(this.usuarios.get(nomeUsuario));
    }

    @Override
    public Optional<UsuarioEntity> pegarUsuarioEntityPorNomeUsuario(String nomeUsuario) {
        return this.pegarUsuarioEntityComSenhaPorNomeUsuario(nomeUsuario).map(this::criarCopiaSemSenha);
    }

    private UsuarioEntity criarCopiaSemSenha(UsuarioEntity usuario) {
        return UsuarioEntity.builder()
                .nomeUsuario(usuario.getNomeUsuario())
                .nome(usuario.getNome())
                .build();
    }

    @Override
    public void salvarUsuarioEntity(UsuarioEntity usuarioEntity) {
        usuarioEntity.setSenha(passwordEncoder.encode(usuarioEntity.getSenha()));
        usuarios.put(usuarioEntity.getNomeUsuario(), usuarioEntity);
        System.out.printf("Usuario adicionado %s%n", usuarioEntity.toString());
    }
}
