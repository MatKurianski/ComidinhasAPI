package com.kurianski.comidinhas.application.usecase.cadastro;

import com.kurianski.comidinhas.adapter.datastore.UsuarioRepository;
import com.kurianski.comidinhas.domain.entity.Usuario;
import com.kurianski.comidinhas.domain.entity.comando.ComandoCadastrarUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {
    private final UsuarioRepository userRepository;

    public void execute(ComandoCadastrarUsuario usuario) {
        userRepository.salvarUsuario(usuario);
    }
}
