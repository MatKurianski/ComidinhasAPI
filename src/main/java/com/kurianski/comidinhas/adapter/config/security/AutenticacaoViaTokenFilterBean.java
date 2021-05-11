package com.kurianski.comidinhas.adapter.config.security;

import com.kurianski.comidinhas.adapter.datastore.UsuarioEntityRepository;
import com.kurianski.comidinhas.adapter.service.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutenticacaoViaTokenFilterBean {

    @Bean
    public AutenticacaoViaTokenFilter autenticacaoViaTokenFilter(TokenService tokenService,
                                                                 UsuarioEntityRepository usuarioEntityRepository) {
        return new AutenticacaoViaTokenFilter(tokenService, usuarioEntityRepository);
    }
}
