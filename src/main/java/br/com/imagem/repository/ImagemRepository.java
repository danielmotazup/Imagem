package br.com.imagem.repository;

import br.com.imagem.model.Imagem;
import org.aspectj.apache.bcel.generic.LineNumberGen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
