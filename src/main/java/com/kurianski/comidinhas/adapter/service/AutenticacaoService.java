package com.kurianski.comidinhas.adapter.service;

import com.kurianski.comidinhas.adapter.datastore.UsuarioEntityRepository;
import com.kurianski.comidinhas.adapter.controller.entity.auth.UsuarioAutenticado;
import com.kurianski.comidinhas.adapter.datastore.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutenticacaoService implements UserDetailsService {
    private final UsuarioEntityRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        Optional<UsuarioEntity> usuario = usuarioRepository.pegarUsuarioEntityComSenhaPorNomeUsuario(nomeUsuario);

        if(usuario.isPresent()) {
            UsuarioEntity usuarioEncontrado = usuario.get();

            return UsuarioAutenticado.builder()
                    .nomeUsuario(usuarioEncontrado.getNomeUsuario())
                    .senha(usuarioEncontrado.getSenha())
                    .build();
        }
        throw new UsernameNotFoundException("Usuário não existe");
    }
}
