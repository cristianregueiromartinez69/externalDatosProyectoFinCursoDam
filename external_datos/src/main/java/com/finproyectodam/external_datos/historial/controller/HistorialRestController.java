package com.finproyectodam.external_datos.historial.controller;

import com.finproyectodam.external_datos.historial.service.HistorialGuardadoService;
import com.finproyectodam.external_datos.model.CancionDTO;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller del historial de spotify
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/spotify")
public class HistorialRestController {

    //servicio de historial
    private final HistorialGuardadoService historialGuardadoService;

    /**
     * Constructor de la clase
     * @param historialGuardadoService el servicio del historial
     */
    public HistorialRestController(HistorialGuardadoService historialGuardadoService) {
        this.historialGuardadoService = historialGuardadoService;
    }

    /**
     * Metodo Get para obtener todas las canciones del historial
     * @return la lista de canciones o null
     */
    @GetMapping("/historial")
    public ResponseEntity<List<CancionDTO>> getAllHistorialCanciones(){
        try{
            List<CancionDTO> cancionesHistorial = historialGuardadoService.getCancionesHistorial(historialGuardadoService.getAllHistorialService());
            if(cancionesHistorial.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else{
                return new ResponseEntity<>(cancionesHistorial, HttpStatus.OK);
            }
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
