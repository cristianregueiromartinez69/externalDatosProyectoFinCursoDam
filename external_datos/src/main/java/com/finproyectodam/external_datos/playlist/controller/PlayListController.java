package com.finproyectodam.external_datos.playlist.controller;

import com.finproyectodam.external_datos.model.PlayListDTO;
import com.finproyectodam.external_datos.playlist.service.PlayListService;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Restcontroller de las playlist
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/spotify/spotify/playlist")
public class PlayListController {

    private final PlayListService playListService;

    /**
     * Constructor del restController de las playlist
     * @param playListService el servicio de playList
     */
    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    /**
     * metodo Post para la creación de una playlist
     * @param playListDTO la playlist a crear
     * @return un mensaje indicando si se creo o no
     */
    @PostMapping("/crear")
    public ResponseEntity<String> createNewPlayListController(@RequestBody PlayListDTO playListDTO) {
        try{
            playListService.createNewPlayListService(playListDTO);
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fe.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("PlayList creada correctamente");
    }
}
