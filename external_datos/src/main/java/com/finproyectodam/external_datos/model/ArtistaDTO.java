package com.finproyectodam.external_datos.model;

import lombok.Data;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de artistas
 * @author cristian && joel
 * @version 1.0
 */
@Data
public class ArtistaDTO {

    //atributos de clase
    private String nameart;
    private String generoMusc;
    private String descrip;
    private Set<AlbumDTO> albumes = new LinkedHashSet<>();
    private Set<CancionDTO> canciones = new LinkedHashSet<>();


}
