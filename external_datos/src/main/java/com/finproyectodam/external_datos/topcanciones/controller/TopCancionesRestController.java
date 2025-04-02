package com.finproyectodam.external_datos.topcanciones.controller;

import com.finproyectodam.external_datos.model.CancionDTO;
import com.finproyectodam.external_datos.topcanciones.service.TopCancionesService;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller de top de canciones
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/spotify")
public class TopCancionesRestController {

    //servicio de top de canciones
    private final TopCancionesService topCancionesService;

    /**
     * Constructor de la clase
     * @param topCancionesService el servicio de top de canciones
     */
    public TopCancionesRestController(TopCancionesService topCancionesService) {
        this.topCancionesService = topCancionesService;
    }

    /**
     * Metodo Get para obtener todas las canciones del top más escuchado
     * @return la lista de canciones
     */
    @GetMapping("/topcanciones")
    public ResponseEntity<List<CancionDTO>> getTopCanciones(){
        try{
            List<CancionDTO> cancionDTOList = topCancionesService.getAllTopCanciones();
            if(cancionDTOList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cancionDTOList, HttpStatus.OK);
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
