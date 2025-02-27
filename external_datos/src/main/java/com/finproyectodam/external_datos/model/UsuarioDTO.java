package com.finproyectodam.external_datos.model;

import lombok.Data;


/**
 * Clase dto de usuarios
 * @author cristian && joel
 * @version 1.0
 */
public class UsuarioDTO {

    //atributo de clase
    private String username;

    /**
     * Constructor de la clase
     * @param username el alias del usuario
     */
    public UsuarioDTO(String username) {
        this.username = username;
    }

    public UsuarioDTO() {

    }

    //getter y setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
