package com.kurianski.comidinhas.adapter.controller;

import com.kurianski.comidinhas.application.usecase.produtos.AdicionarProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {
    private final AdicionarProdutoUseCase adicionarProdutoUseCase;
}
