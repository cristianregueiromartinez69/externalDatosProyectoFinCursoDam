package com.finproyectodam.external_datos.randomplaylist.controller;


import com.finproyectodam.external_datos.model.PlayListDTO;
import com.finproyectodam.external_datos.randomplaylist.service.RandomPLaylistService;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * rest controller de la playlist aleatoria en el inicio
 * @author cristian && joel
 * @version 1.0
 */
@RestController
@RequestMapping("/spotify")
public class RandomPlaylistRestController {

    //variable del servicio de playlist aleatoria
    private final RandomPLaylistService randomPLaylistService;

    /**
     * Constructor de la clase
     * @param randomPLaylistService el servicio de playlist aleatoria
     */
    public RandomPlaylistRestController(RandomPLaylistService randomPLaylistService) {
        this.randomPLaylistService = randomPLaylistService;
    }

    /**
     * Metodo Get para obtener una playlist aleatoria al entrar a la web
     * @return la playlist o null
     */
    @GetMapping("/inicio")
    public ResponseEntity<PlayListDTO> getInitRandomPLaylist(){
        try{
            PlayListDTO playListDTO = randomPLaylistService.getRandomPlayList();
            if(playListDTO == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(playListDTO);
        }catch(FeignException fe){
            if(fe.status() == HttpStatus.BAD_REQUEST.value()){
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();
    }
}
