package com.finproyectodam.external_datos.usuarios.loginusuarios.model;

/**
 * Clase dto de login de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
public class LoginUsuariosDTO {

    //atributos de clase
    private String email;
    private String passwordU;

    /**
     * Contructor de la clase
     * @param email el email del usuario
     * @param passwordU la contraseña del usuario
     */
    public LoginUsuariosDTO(String email, String passwordU) {
        this.email = email;
        this.passwordU = passwordU;
    }

    public LoginUsuariosDTO() {
    }

    //getter y setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }

}
