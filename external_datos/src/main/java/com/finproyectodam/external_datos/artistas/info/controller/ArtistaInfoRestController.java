package com.finproyectodam.external_datos.artistas.info.controller;

import com.finproyectodam.external_datos.artistas.info.service.ArtistasInfoService;
import com.finproyectodam.external_datos.artistas.model.ArtistaDTO;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spotify/artistas/info")
public class ArtistaInfoRestController {

    private final ArtistasInfoService artistasInfoService;

    public ArtistaInfoRestController(ArtistasInfoService artistasInfoService) {
        this.artistasInfoService = artistasInfoService;
    }

    @GetMapping("/nombre{nombre}")
    public ResponseEntity<ArtistaDTO> getArtistaByNombreController(@PathVariable String nombre) {
        try{
            ArtistaDTO artistaDTO = artistasInfoService.getArtistaNombre(nombre);
            if(artistaDTO != null) {
                return ResponseEntity.ok(artistaDTO);
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
