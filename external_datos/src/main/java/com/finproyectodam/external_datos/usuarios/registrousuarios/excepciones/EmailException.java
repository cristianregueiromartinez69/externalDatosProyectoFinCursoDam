package com.finproyectodam.external_datos.usuarios.registrousuarios.excepciones;

/**
 * Excepcion del email incorrecto en el registro de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
public class EmailException extends RuntimeException {
    public EmailException(String message) {
        super(message);
    }
}
