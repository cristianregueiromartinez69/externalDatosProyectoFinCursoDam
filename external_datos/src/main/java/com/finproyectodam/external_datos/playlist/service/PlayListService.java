package com.finproyectodam.external_datos.playlist.service;

import com.finproyectodam.external_datos.model.PlayListDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

@Service
public class PlayListService {

    private final ServicioDB servicioDB;

    public PlayListService(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    public void createNewPlayListService(PlayListDTO playListDTO) {

        PlayListDTO auxPlayListDTO = new PlayListDTO(playListDTO.getTitulo(),
                playListDTO.getFechacre(), playListDTO.getDescrip(),
                playListDTO.getUserid());

        servicioDB.createNewPlayList(auxPlayListDTO);
    }

}
