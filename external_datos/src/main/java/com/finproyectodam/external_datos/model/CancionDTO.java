package com.finproyectodam.external_datos.model;


import lombok.Data;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de canciones
 * @author cristian && joel
 * @version 1.0
 */
@Data
public class CancionDTO {

    //atributos de clase
    private String titulo;
    private Integer duracion;
    private String urlcancion;
    private ArtistaDTO artistaid;
    private AlbumDTO albumid;
    private Set<PlayListDTO> playlists = new LinkedHashSet<>();


}
