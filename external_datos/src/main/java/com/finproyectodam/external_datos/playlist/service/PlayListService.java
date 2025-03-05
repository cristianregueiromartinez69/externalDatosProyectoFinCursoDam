package com.finproyectodam.external_datos.playlist.service;

import com.finproyectodam.external_datos.model.PlayListDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

/**
 * Servicio de playlist
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class PlayListService {

    //variable de servicio de comunicacion
    private final ServicioDB servicioDB;

    /**
     * Constructor del servicio
     * @param servicioDB el servicio de comunicacion
     */
    public PlayListService(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    /**
     * Metodo para crear una nueva playList
     * @param playListDTO el objeto playlist
     */
    public void createNewPlayListService(PlayListDTO playListDTO) {

        PlayListDTO auxPlayListDTO = new PlayListDTO(playListDTO.getTitulo(),
                playListDTO.getFechacre(), playListDTO.getDescrip());

        servicioDB.createNewPlayList(auxPlayListDTO);
    }

    /**
     * Metodo para añadir canciones a una playlist
     * @param playlistId el id de la playlist
     * @param cancionId el id de la cancion
     */
    public void addNewPlaylistCancionService(Integer playlistId, Integer cancionId) {
        servicioDB.addNewCancionesPlayList(playlistId, cancionId);
    }

}
