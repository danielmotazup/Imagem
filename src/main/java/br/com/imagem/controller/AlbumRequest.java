package br.com.imagem.controller;

import br.com.imagem.model.Album;

public class AlbumRequest {

    private String titulo;

    private String descricao;

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }


    public Album toModel(){
        return new Album(this.titulo,this.descricao);
    }
}
