package com.kurianski.comidinhas.domain.entity.comando;

import lombok.Data;

@Data
public class ComandoAutenticarUsuario {
    private String nomeUsuario;
    private String senha;
}
