package com.finproyectodam.external_datos.registrousuarios.excepciones;

/**
 * Excepcion del password incorrecto en el registro de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
public class PasswordException extends RuntimeException {
    public PasswordException(String message) {
        super(message);
    }
}
