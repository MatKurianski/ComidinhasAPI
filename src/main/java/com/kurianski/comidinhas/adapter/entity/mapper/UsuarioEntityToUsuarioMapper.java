package com.kurianski.comidinhas.adapter.entity.mapper;

import com.kurianski.comidinhas.domain.entity.Usuario;
import com.kurianski.comidinhas.adapter.entity.datastore.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityToUsuarioMapper implements EntityMapper<UsuarioEntity, Usuario> {

    @Override
    public Usuario map(UsuarioEntity usuarioEntity) {
        return Usuario.builder()
                .nome(usuarioEntity.getNome())
                .nomeUsuario(usuarioEntity.getNomeUsuario())
                .build();
    }
}
