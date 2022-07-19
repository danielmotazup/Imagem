package br.com.imagem.model;

import javax.persistence.*;
import java.awt.font.ImageGraphicAttribute;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Imagem> imagens = new HashSet<>();

    private LocalDate dataCriacao = LocalDate.now();

    @Deprecated
    public Album() {
    }

    public Album(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public Set<Imagem> getImagens() {
        return imagens;
    }

    public void adicionar(Imagem imagem){
        this.getImagens().add(imagem);

    }


}
