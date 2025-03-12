package com.finproyectodam.external_datos.randomplaylist.service;

import com.finproyectodam.external_datos.model.PlayListDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

/**
 * Servicio de random playlist
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class RandomPLaylistService {

    //atributo del servicio de comunicacion
    private final ServicioDB servicioDB;

    /**
     * Constructor de la clase
     * @param servicioDB el servicio de comunicacion
     */
    public RandomPLaylistService(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    /**
     * Metodo para obtener una playlist aleatoria al entrar a la web
     * @return la playlist aleatoria
     */
    public PlayListDTO getRandomPlayList() {
        return servicioDB.getInitPlaylistSpotify();
    }
}
