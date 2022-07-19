package br.com.imagem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imagem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
