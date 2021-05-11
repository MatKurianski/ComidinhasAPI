package com.kurianski.comidinhas.adapter.datastore;

import com.kurianski.comidinhas.domain.entity.Usuario;
import com.kurianski.comidinhas.domain.entity.comando.ComandoCadastrarUsuario;
import com.kurianski.comidinhas.adapter.entity.datastore.UsuarioEntity;
import com.kurianski.comidinhas.adapter.entity.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final EntityMapper<ComandoCadastrarUsuario, UsuarioEntity> comandoToEntityMapper;
    private final EntityMapper<UsuarioEntity, Usuario> entityToUsuarioMapper;
    private final UsuarioEntityRepository usuarioEntityRepository;

    @Override
    public void salvarUsuario(ComandoCadastrarUsuario comandoCadastrarUsuario) {
        UsuarioEntity usuarioEntity = comandoToEntityMapper.map(comandoCadastrarUsuario);
        usuarioEntityRepository.salvarUsuarioEntity(usuarioEntity);
    }

    @Override
    public Optional<Usuario> pegarUsuarioPorNomeUsuario(String nomeUsuario) {
        return usuarioEntityRepository
                .pegarUsuarioEntityPorNomeUsuario(nomeUsuario)
                .map(entityToUsuarioMapper::map);
    }
}
