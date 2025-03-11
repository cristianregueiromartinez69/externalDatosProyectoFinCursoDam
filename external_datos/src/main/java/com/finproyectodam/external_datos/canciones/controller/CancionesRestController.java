package com.finproyectodam.external_datos.canciones.controller;

import com.finproyectodam.external_datos.canciones.service.CancionesService;
import com.finproyectodam.external_datos.model.CancionDTO;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController de las canciones
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/spotify/canciones")
public class CancionesRestController {

    //servicio de las canciones
    private final CancionesService cancionesService;

    /**
     * Constructor de la clase
     * @param cancionesService el servicio de las canciones
     */
    public CancionesRestController(CancionesService cancionesService) {
        this.cancionesService = cancionesService;
    }

    /**
     * Metodo get para obtener todas las canciones de la base de datos
     * @return la lista de canciones o null
     */
    @GetMapping("/info")
    public ResponseEntity<List<CancionDTO>> getAllSongsController(){
        try{
            List<CancionDTO> cancionDTOList = cancionesService.getAllSongs();
            if(cancionDTOList.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            else{
                return ResponseEntity.ok(cancionDTOList);
            }
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();
    }

    /**
     * Metodo para obtener una cancion por el id de la misma
     * @param id el id de la cancion
     * @return la cancion o null
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<CancionDTO> getSongByIdController(@PathVariable Integer id){
        try{
            CancionDTO cancionDTO = cancionesService.getCancionByIdService(id);
            if(cancionDTO == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(cancionDTO);
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Metodo para obtener una cancion o canciones por el titulo
     * @param titulo el titulo de la cancion
     * @return la cancion o canciones o null
     */
    @GetMapping("/info/{titulo}")
    public ResponseEntity<List<CancionDTO>> getSongByTituloController(@PathVariable String titulo){
        try{
            List<CancionDTO> cancionDTOList = cancionesService.getCancionByTituloService(titulo);
            if(cancionDTOList.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            else{
                return ResponseEntity.ok(cancionDTOList);
            }
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.notFound().build();
    }
}
