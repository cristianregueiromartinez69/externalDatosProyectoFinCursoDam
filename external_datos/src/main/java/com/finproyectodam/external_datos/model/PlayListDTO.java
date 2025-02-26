package com.finproyectodam.external_datos.model;


import lombok.Data;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de playlist
 * @author cristian && joel
 * @version 1.0
 */
@Data
public class PlayListDTO {

    //atributos de clase
    private String titulo;
    private LocalDate fechacre;
    private String descrip;
    private UsuarioDTO userid;
    private Set<CancionDTO> canciones = new LinkedHashSet<>();


}
