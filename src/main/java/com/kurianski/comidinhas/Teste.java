package com.kurianski.comidinhas;

import com.kurianski.comidinhas.application.usecase.cadastro.CadastrarUsuarioUseCase;
import com.kurianski.comidinhas.application.usecase.produtos.AdicionarProdutoUseCase;
import com.kurianski.comidinhas.application.usecase.produtos.PegarProdutosdeUsuarioUseCase;
import com.kurianski.comidinhas.domain.entity.Categoria;
import com.kurianski.comidinhas.domain.entity.comando.ComandoAdicionarProduto;
import com.kurianski.comidinhas.domain.entity.comando.ComandoCadastrarUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Teste {
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final AdicionarProdutoUseCase adicionarProdutoUseCase;
    private final PegarProdutosdeUsuarioUseCase pegarProdutosdeUsuarioUseCase;

    @PostConstruct
    public void run() throws InterruptedException {
        var usuario1 = ComandoCadastrarUsuario.builder()
                .nomeUsuario("exemplo1")
                .nome("Exemplo1")
                .email("exemplo1@exemplo.com")
                .senha("123")
                .dataNascimento(LocalDate.now().minusYears(20))
                .build();


        var usuario2 = ComandoCadastrarUsuario.builder()
                .nomeUsuario("exemplo2")
                .nome("Exemplo2")
                .email("exemplo2@exemplo.com")
                .senha("123")
                .dataNascimento(LocalDate.now().minusYears(20))
                .build();

        cadastrarUsuarioUseCase.execute(usuario1);
        cadastrarUsuarioUseCase.execute(usuario2);

        var categoria = Categoria.builder().nome("salgado").descricao("legal").build();

        var comandoAdicionarProduto = ComandoAdicionarProduto.builder()
                .nomeUsuarioVendedor(usuario1.getNomeUsuario())
                .descricao("salve")
                .nome("salve")
                .urlImagem("as")
                .valor(BigDecimal.TEN)
                .nomesCategorias(List.of(categoria.getNome()))
                .build();

        adicionarProdutoUseCase.adicionar(comandoAdicionarProduto);

        System.out.println(pegarProdutosdeUsuarioUseCase.pegar(usuario1.getNomeUsuario()));
    }
}
