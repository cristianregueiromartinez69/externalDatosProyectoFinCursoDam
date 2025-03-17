package com.finproyectodam.external_datos.historial.service;

import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

/**
 * Servicio del historial de guardado de canciones
 * @author cristian
 * @version
 */
@Service
public class HistorialService {

    //atributo del servicio de comunicacion
    private final ServicioDB servicioDB;

    /**
     * Constructor de la clase
     * @param servicioDB el servicio de comunicacion
     */
    public HistorialService(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    /**
     * Metodo para guardar la cancion cuando el usuario le de al play
     * @param id el id de la cancion
     */
    public void saveCancionHistorialService(Integer id){
        servicioDB.saveCancionHistorial(id);
    }
}
