package com.finproyectodam.external_datos.usuarios.loginusuarios.model;

public class LoginUsuariosDTO {

    private String email;
    private String passwordU;

    public LoginUsuariosDTO(String email, String passwordU) {
        this.email = email;
        this.passwordU = passwordU;
    }

    public LoginUsuariosDTO() {
    }

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
