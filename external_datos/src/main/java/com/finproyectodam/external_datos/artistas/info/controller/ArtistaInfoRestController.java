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

import java.util.List;

@RestController
@RequestMapping("/spotify/artistas/info")
public class ArtistaInfoRestController {

    private final ArtistasInfoService artistasInfoService;

    public ArtistaInfoRestController(ArtistasInfoService artistasInfoService) {
        this.artistasInfoService = artistasInfoService;
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ArtistaDTO> getArtistaByNombreController(@PathVariable String nombre) {
        try{
            ArtistaDTO artistaDTO = artistasInfoService.getArtistaNombre(nombre);
            return ResponseEntity.ok(artistaDTO);
        } catch (FeignException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<ArtistaDTO>> getArtistaByGeneroController(@PathVariable String genero) {
        try{
            List<ArtistaDTO> artistaList = artistasInfoService.getAllArtistasByGenero(genero);
            return ResponseEntity.ok(artistaList);
        }catch (FeignException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ArtistaDTO> getArtistaByIdController(@PathVariable Integer id) {
        try{
            ArtistaDTO artistaDTO = artistasInfoService.getArtistaById(id);
            return ResponseEntity.ok(artistaDTO);
        }catch (FeignException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
