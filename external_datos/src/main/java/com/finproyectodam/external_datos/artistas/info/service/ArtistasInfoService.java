package com.finproyectodam.external_datos.artistas.info.service;

import com.finproyectodam.external_datos.artistas.model.ArtistaDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

@Service
public class ArtistasInfoService {

    private final ServicioDB servicioDB;

    public ArtistasInfoService(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    public ArtistaDTO getArtistaNombre(String nombre) {
        return servicioDB.getArtistaByNombre(nombre);
    }
}
