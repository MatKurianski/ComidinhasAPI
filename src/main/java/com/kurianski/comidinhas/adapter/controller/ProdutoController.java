package com.kurianski.comidinhas.adapter.controller;

import com.kurianski.comidinhas.adapter.controller.entity.auth.UsuarioAutenticado;
import com.kurianski.comidinhas.adapter.controller.entity.request.AdicionarProdutoRequest;
import com.kurianski.comidinhas.adapter.controller.mapper.response.AdicionarProdutoRequestToComandoAdicionarProdutoMapper;
import com.kurianski.comidinhas.application.usecase.produtos.AdicionarProdutoUseCase;
import com.kurianski.comidinhas.domain.entity.comando.ComandoAdicionarProduto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/produtos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {
    private final AdicionarProdutoUseCase adicionarProdutoUseCase;
    private final AdicionarProdutoRequestToComandoAdicionarProdutoMapper mapper;

    @PostMapping("/adicionar")
    public ResponseEntity<ComandoAdicionarProduto> adicionarProduto(@RequestBody @Valid AdicionarProdutoRequest adicionarProdutoRequest) {
        ComandoAdicionarProduto comandoAdicionarProduto = mapper.map(adicionarProdutoRequest);

        var usuarioAutenticado = (UsuarioAutenticado) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        comandoAdicionarProduto.setNomeUsuarioVendedor(usuarioAutenticado.getNomeUsuario());

        adicionarProdutoUseCase.adicionar(comandoAdicionarProduto);
        return ResponseEntity.ok(comandoAdicionarProduto);
    }
}
