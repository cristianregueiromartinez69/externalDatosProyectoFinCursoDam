package com.finproyectodam.external_datos.artistas.info.service;

import com.finproyectodam.external_datos.model.ArtistaDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio con la lógica de búsqueda de información de artistas
 * @author cristian & joel
 * @version 1.0
 */
@Service
public class ArtistasInfoService {

    //variable del servicio
    private final ServicioDB servicioDB;

    /**
     * Constructor de la clase
     * @param servicioDB el servicio de comunicacion
     */
    public ArtistasInfoService(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    /**
     * metodo que devuelve un artista por el nombre desde el microservicio de la base de datos
     * @param nombre el nombre del artista
     * @return el artista o null
     */
    public ArtistaDTO getArtistaNombre(String nombre) {
        System.out.println(servicioDB.getArtistaByNombre(nombre));
        return servicioDB.getArtistaByNombre(nombre);
    }

    /**
     * metodo que devuelve una lista de artistas por el genero desde el microservicio de la base de datos
     * @param genero el genero musical
     * @return la lista de artistas o null
     */
    public List<ArtistaDTO> getAllArtistasByGenero(String genero) {
        return servicioDB.getArtistaByGenero(genero);
    }

    /**
     * metodo que devuelve un artista por el id desde el microservicio de la base de datos
     * @param id el id del artista
     * @return el artista o null
     */
    public ArtistaDTO getArtistaById(Integer id) {
        return servicioDB.getArtistaById(id);
    }
}
