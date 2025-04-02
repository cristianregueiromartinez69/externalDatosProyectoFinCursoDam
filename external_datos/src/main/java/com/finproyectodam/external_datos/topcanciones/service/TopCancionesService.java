package com.finproyectodam.external_datos.topcanciones.service;

import com.finproyectodam.external_datos.model.CancionDTO;
import com.finproyectodam.external_datos.model.TopCancionesDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioMongo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private final ServicioDB servicioDB;

    /**
     * Constructor de la clase
     * @param servicioMongo el servicio de mongo
     */
    public TopCancionesService(ServicioMongo servicioMongo, ServicioDB servicioDB) {
        this.servicioMongo = servicioMongo;
        this.servicioDB = servicioDB;
    }

    /**
     * Metodo que devuelve una lista top 10 o menos de las canciones escuchadas
     * @return la lista de canciones
     */
    public List<TopCancionesDTO> getAllTopCanciones(){
        return servicioMongo.getTopCanciones();
    }

    /**
     * Metodo para obtener todas las canciones top de la app
     * @param topCanciones el top de mongo
     * @return la nueva lista de canciones
     */
    public List<CancionDTO> getAllCancionesTopEscuchadas(List<TopCancionesDTO> topCanciones){
        List<CancionDTO> cancionDTOList = new ArrayList<>();

        for(TopCancionesDTO topCancion : topCanciones){
            CancionDTO cancionDTO = servicioDB.getCancionById(topCancion.getIdCancion());
            cancionDTOList.add(cancionDTO);
        }
        return cancionDTOList;
    }



}
