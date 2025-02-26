package com.finproyectodam.external_datos.albumes.info.controller;

import com.finproyectodam.external_datos.albumes.info.service.AlbumesInfoService;
import com.finproyectodam.external_datos.model.AlbumDTO;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoint del album para coger su información
 * @author cristian & joel
 * @version 1.0
 */
@RestController
@RequestMapping("/spotify/albumes/info")
public class AlbumesInfoRestController {

    //variable del servicio
    private final AlbumesInfoService albumesInfoService;

    /**
     * Constructor de la clase
     * @param albumesInfoService el servicio de albumes
     */
    public AlbumesInfoRestController(AlbumesInfoService albumesInfoService) {
        this.albumesInfoService = albumesInfoService;
    }

    /**
     * Metodo Get para obtener albumes por el id
     * @param id el id del album
     * @return el album o null
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<AlbumDTO> getAlbumByIdRestController(@PathVariable Integer id){
        try{
            AlbumDTO albumDTO = albumesInfoService.getAlbumByIdService(id);
            return ResponseEntity.ok(albumDTO);
        }catch (FeignException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Metodo Get para obtener un album por el titulo
     * @param titulo el titulo del album
     * @return el album o null
     */
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<AlbumDTO> getAlbumByTituloRestController(@PathVariable String titulo){
        try{
            AlbumDTO albumDTO = albumesInfoService.getAlbumByTituloService(titulo);
            return ResponseEntity.ok(albumDTO);
        }catch (FeignException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Metodo Get para obtener albumes entre años de lanzamiento
     * @param anoInicio la fecha de inicio
     * @param anoFin la fecha de fin
     * @return la lista de albumes o null
     */
    @GetMapping("/anolanz}")
    public ResponseEntity <List<AlbumDTO>> getAlbumByTituloRestController(@RequestParam("anoInit") Integer anoInicio,
                                                                   @RequestParam("anoFin") Integer anoFin){
        try{
            List<AlbumDTO> albumDTO = albumesInfoService.getAlbumesbetweenAnosLanz(anoInicio, anoFin);
            return ResponseEntity.ok(albumDTO);
        }catch (FeignException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
