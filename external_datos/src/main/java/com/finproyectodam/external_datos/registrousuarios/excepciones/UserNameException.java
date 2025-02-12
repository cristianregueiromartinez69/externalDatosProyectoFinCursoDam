package com.finproyectodam.external_datos.registrousuarios.excepciones;

/**
 * Excepcion del alias incorrecto en el registro de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
public class UserNameException extends RuntimeException {
    public UserNameException(String message) {
        super(message);
    }
}
