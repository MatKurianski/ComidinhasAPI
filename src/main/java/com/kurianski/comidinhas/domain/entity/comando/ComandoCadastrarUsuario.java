package com.kurianski.comidinhas.domain.entity.comando;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class ComandoCadastrarUsuario {
    String nomeUsuario;
    String nome;
    String email;
    String senha;
    LocalDate dataNascimento;
}
