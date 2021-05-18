package com.kurianski.comidinhas.adapter.datastore.mapper;

import com.kurianski.comidinhas.domain.entity.comando.ComandoCadastrarUsuario;
import com.kurianski.comidinhas.adapter.datastore.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ComandoCadastrarUsuarioToUsuarioEntityMapper implements EntityMapper<ComandoCadastrarUsuario, UsuarioEntity> {

    @Override
    public UsuarioEntity map(ComandoCadastrarUsuario comandoCadastrarUsuario) {
        return UsuarioEntity.builder()
                .nomeUsuario(comandoCadastrarUsuario.getNomeUsuario())
                .nome(comandoCadastrarUsuario.getNome())
                .email(comandoCadastrarUsuario.getEmail())
                .senha(comandoCadastrarUsuario.getSenha())
                .dataNascimento(comandoCadastrarUsuario.getDataNascimento())
                .build();
    }
}
