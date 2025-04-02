package com.finproyectodam.external_datos.topcanciones.service;

import com.finproyectodam.external_datos.model.CancionDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioMongo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de obtencion de top de canciones de spotify
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class TopCancionesService {

    //atributo de clase
    private final ServicioMongo servicioMongo;

    /**
     * Constructor de la clase
     * @param servicioMongo el servicio de mongo
     */
    public TopCancionesService(ServicioMongo servicioMongo) {
        this.servicioMongo = servicioMongo;
    }

    /**
     * Metodo que devuelve una lista top 10 o menos de las canciones escuchadas
     * @return la lista de canciones
     */
    public List<CancionDTO> getAllTopCanciones(){
        List<CancionDTO> cancionDTOList = servicioMongo.getTopCanciones();
        return cancionDTOList.size() > 10 ? cancionDTOList.subList(0, 10) : cancionDTOList;
    }
}
