package com.kurianski.comidinhas.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {
    private String nomeUsuario;
    private String nome;
}
