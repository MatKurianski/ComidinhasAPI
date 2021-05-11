package com.kurianski.comidinhas.adapter.controller;

import com.kurianski.comidinhas.adapter.entity.response.MensagemResposta;
import com.kurianski.comidinhas.adapter.entity.response.TokenResposta;
import com.kurianski.comidinhas.adapter.service.TokenService;
import com.kurianski.comidinhas.application.usecase.cadastro.CadastrarUsuarioUseCase;
import com.kurianski.comidinhas.domain.entity.comando.ComandoAutenticarUsuario;
import com.kurianski.comidinhas.domain.entity.comando.ComandoCadastrarUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AutenticacaoController {
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping(path = "/signup")
    public ResponseEntity<MensagemResposta> cadastrarUsuario(@RequestBody ComandoCadastrarUsuario comandoCadastrarUsuario) {
        cadastrarUsuarioUseCase.execute(comandoCadastrarUsuario);
        return ResponseEntity.ok(new MensagemResposta("Criado com sucesso"));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<TokenResposta> autenticar(@RequestBody ComandoAutenticarUsuario comandoAutenticarUsuario) {
        UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(comandoAutenticarUsuario.getNomeUsuario(), comandoAutenticarUsuario.getSenha());
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenResposta("Bearer", token));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
