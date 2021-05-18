package com.kurianski.comidinhas.adapter.datastore.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UsuarioEntity {
    private String nomeUsuario;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
}
