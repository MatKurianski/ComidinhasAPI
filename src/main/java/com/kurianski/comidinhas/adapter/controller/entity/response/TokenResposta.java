package com.kurianski.comidinhas.adapter.controller.entity.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenResposta {
    private final String tipo;
    private final String token;
}
