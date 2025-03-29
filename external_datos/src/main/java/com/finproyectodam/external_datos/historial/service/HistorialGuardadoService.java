package com.finproyectodam.external_datos.historial.service;

import com.finproyectodam.external_datos.servicio_comunicacion.ServicioMongo;
import org.springframework.stereotype.Service;

/**
 * Servicio del historial de guardado de canciones
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class HistorialGuardadoService {

    //atributo del servicio de comunicacion
    private final ServicioMongo servicioMongo;

    /**
     * Constructor de la clase
     * @param servicioMongo el servicio de comunicacion
     */
    public HistorialGuardadoService(ServicioMongo servicioMongo) {
        this.servicioMongo = servicioMongo;
    }

    /**
     * Metodo para guardar la cancion cuando el usuario le de al play
     * @param idCancion el id de la cancion
     */
    public void saveCancionHistorialService(Integer idCancion){
        servicioMongo.saveCancionHistorial(idCancion);
    }
}
