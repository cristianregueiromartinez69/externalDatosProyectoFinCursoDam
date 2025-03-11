package com.finproyectodam.external_datos.canciones.service;

import com.finproyectodam.external_datos.model.CancionDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de las canciones
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class CancionesService {

    //variable de servicio de comunicacion
    private final ServicioDB servicioDB;

    /**
     * Constructor de la clase
     * @param servicioDB el servicio de comunicacion
     */
    public CancionesService(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    /**
     * Metodo para obtener todas las canciones de la base de datos
     * @return la lista de canciones o null
     */
    public List<CancionDTO> getAllSongs(){
        List<CancionDTO> cancionDTOList = servicioDB.getAllCanciones();
        if(cancionDTOList.isEmpty()){
            return null;
        }
        return cancionDTOList;
    }
}
