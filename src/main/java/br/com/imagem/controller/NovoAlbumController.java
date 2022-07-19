package br.com.imagem.controller;

import br.com.imagem.model.Album;
import br.com.imagem.repository.AlbumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/albuns")
public class NovoAlbumController {

    private final AlbumRepository albumRepository;

    public NovoAlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastraAlbum(@RequestBody @Valid AlbumRequest request, UriComponentsBuilder uriComponentsBuilder){

        Album album = request.toModel();
        albumRepository.save(album);

        URI location = uriComponentsBuilder.path("/album/{id}").buildAndExpand(album.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
