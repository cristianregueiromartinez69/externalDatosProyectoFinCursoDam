package com.finproyectodam.external_datos.historial.controller;

import com.finproyectodam.external_datos.historial.service.HistorialGuardadoService;
import com.finproyectodam.external_datos.model.CancionDTO;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Metodo de borrado de cancion del historial por id
     * @param idCancion el id de la cancion
     * @return un mensaje descriptivo
     */
    @DeleteMapping("/historial/borrar/id/{idCancion}")
    public ResponseEntity<String> borrarHistorialById(@PathVariable Integer idCancion){
        try{
            historialGuardadoService.deleteHistorialByIdService(idCancion);
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok("Cancion eliminada del historial");
    }

    /**
     * Metodo para borrar el historial entero de un usuario
     * @return un mensaje descriptivo indicando si se borro el historial entero o no
     */
    @DeleteMapping("/historial/borrar")
    public ResponseEntity<String> borrarTodoHistorial(){
        try{
            historialGuardadoService.deleteAllHistorial();
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok("Historial eliminado");
    }
}
