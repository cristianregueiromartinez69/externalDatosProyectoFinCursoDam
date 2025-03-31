package com.finproyectodam.external_datos.historial.service;

import com.finproyectodam.external_datos.model.CancionDTO;
import com.finproyectodam.external_datos.model.HistorialDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioMongo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio del historial de guardado de canciones
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class HistorialGuardadoService {

    //atributo del servicio de comunicacion
    private final ServicioMongo servicioMongo;
    private final ServicioDB servicioDB;

    /**
     * Constructor de la clase
     * @param servicioMongo el servicio de comunicacion
     */
    public HistorialGuardadoService(ServicioMongo servicioMongo, ServicioDB servicioDB) {
        this.servicioMongo = servicioMongo;
        this.servicioDB = servicioDB;
    }

    /**
     * Metodo para guardar la cancion cuando el usuario le de al play
     * @param idCancion el id de la cancion
     */
    public void saveCancionHistorialService(Integer idCancion){
        servicioMongo.saveCancionHistorial(idCancion);
    }

    /**
     * Metodo para obtener el historial de mis canciones
     * @return la lista de historial de canciones
     */
    private List<HistorialDTO> getAllHistorialService(){
        return servicioMongo.getAllHistorial();
    }

    /**
     * Metodo para obtener la información de todas las canciones del historial
     * @param historial una lista del historial
     * @return la lista de canciones
     */
    public List<CancionDTO> getCancionesHistorial(List<HistorialDTO> historial){
        List<CancionDTO> cancionesHistorial = new ArrayList<>();
        for (HistorialDTO historialDTO : historial) {
            CancionDTO cancionDTO = servicioDB.getCancionById(historialDTO.getIdCancion());
            cancionesHistorial.add(cancionDTO);
        }
        return cancionesHistorial;
    }

}
