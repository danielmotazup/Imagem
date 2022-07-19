package br.com.imagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Imagem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String endereco;

    @NotNull
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Deprecated
    public Imagem() {
    }

    public Imagem(String titulo, String desricao, String endereco) {
        this.titulo = titulo;
        this.descricao = desricao;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }
}
