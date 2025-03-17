package com.finproyectodam.external_datos.historial.controller;

import com.finproyectodam.external_datos.historial.service.HistorialGuardadoService;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller del historial de canciones de guardado
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/spotify/artistas/canciones")
public class HistorialGuardadoRestController {

    //servicio de guardado de playlist
    private final HistorialGuardadoService historialGuardadoService;

    /**
     * Constructor de la clase
     * @param historialGuardadoService el historial de guardado de playlist
     */
    public HistorialGuardadoRestController(HistorialGuardadoService historialGuardadoService) {
        this.historialGuardadoService = historialGuardadoService;
    }

    /**
     * Metodo post para guardar una cancion en el historial al escucharla
     * @param id el id de la cancion
     * @return un mensaje indicando que se guardó la cancion
     */
    @PostMapping("/play/id/{id}")
    public ResponseEntity<String> saveCancionHistorialRestController(@PathVariable Integer id) {
        try{
            historialGuardadoService.saveCancionHistorialService(id);
        }catch (FeignException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Cancion guardada en el hostorial");
    }
}
