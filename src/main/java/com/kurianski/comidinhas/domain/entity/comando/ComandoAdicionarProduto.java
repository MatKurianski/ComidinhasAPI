package com.kurianski.comidinhas.domain.entity.comando;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComandoAdicionarProduto {
    private String nome;
    private String urlImagem;
    private BigDecimal valor;
    private String descricao;
    private String nomeUsuarioVendedor;
    private List<String> nomesCategorias;
}
