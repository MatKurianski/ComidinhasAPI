package com.kurianski.comidinhas.adapter.config.security;

import com.kurianski.comidinhas.adapter.datastore.UsuarioEntityRepository;
import com.kurianski.comidinhas.adapter.entity.auth.UsuarioAutenticado;
import com.kurianski.comidinhas.adapter.service.TokenService;
import com.kurianski.comidinhas.adapter.entity.datastore.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UsuarioEntityRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        Optional<String> token = recuperarToken(httpServletRequest);

        if (token.isPresent() && tokenService.isTokenValido(token.get())) {
            autenticarCliente(token.get());
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void autenticarCliente(String token) {
        String idUsuario = tokenService.getNomeUsuarioFromToken(token);
        Optional<UsuarioEntity> usuario = repository.pegarUsuarioEntityComSenhaPorNomeUsuario(idUsuario);

        UsuarioAutenticado usuarioAutenticado = usuario.map(usuarioEncontrado ->
            UsuarioAutenticado.builder()
                    .nomeUsuario(usuarioEncontrado.getNomeUsuario())
                    .senha(usuarioEncontrado.getSenha())
                    .build()
        ).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuarioAutenticado, null, usuarioAutenticado.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private Optional<String> recuperarToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if (Objects.isNull(token) || token.isEmpty() || !token.startsWith("Bearer ")) return Optional.empty();
        return Optional.of(token.substring(7));
    }
}
