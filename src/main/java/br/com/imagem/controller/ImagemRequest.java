package br.com.imagem.controller;

import br.com.imagem.model.Imagem;

import javax.validation.constraints.NotBlank;

public class ImagemRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotBlank
    private String endereco;

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public Imagem toModel(){
        return new Imagem(titulo,descricao,endereco);
    }
}
