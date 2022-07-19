package br.com.imagem.controller;

import br.com.imagem.model.Album;
import br.com.imagem.model.Imagem;
import br.com.imagem.repository.AlbumRepository;
import br.com.imagem.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/albuns/{idAlbum}/imagens")
public class NovaImagemController {

    @Autowired
    private ImagemRepository imagemRepository;
    @Autowired
    private AlbumRepository albumRepository;

    @PostMapping
    public ResponseEntity<Void> cadstraImagem(@PathVariable Long idAlbum, @RequestBody @Valid ImagemRequest request,
                                              UriComponentsBuilder uriComponentsBuilder){

        Album album = albumRepository.findById(idAlbum).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "album não encontrado"));

        Imagem imagem = request.toModel();

        album.adicionar(imagem);
        albumRepository.save(album);

        URI location = uriComponentsBuilder.path("/albuns/{idAlbum}/imagens/{id}")
                .buildAndExpand(idAlbum,imagem.getId()).toUri();

        return ResponseEntity.created(location).build();

    }


}
