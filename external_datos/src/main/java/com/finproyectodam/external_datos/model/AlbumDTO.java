package com.finproyectodam.external_datos.model;



import lombok.Data;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de albumes
 * @author cristian && joel
 * @version 1.0
 */
@Data
public class AlbumDTO {

    //atributos de clase
    private String titulo;
    private Integer anolanz;
    private ArtistaDTO artistaid;
    private Set<CancionDTO> canciones = new LinkedHashSet<>();


}
