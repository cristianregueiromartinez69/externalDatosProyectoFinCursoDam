package com.finproyectodam.external_datos.registrousuarios.model;

import java.time.LocalDate;

public class RegistroUsuariosDTO {

    private String username;
    private String email;
    private String passwordU;
    private LocalDate dateReg;

    public RegistroUsuariosDTO(String userName, String correo, String password, LocalDate dateReg) {
        this.username = userName;
        this.email = correo;
        this.passwordU = password;
        this.dateReg = dateReg;
    }

    public RegistroUsuariosDTO() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public LocalDate getDateReg() {
        return dateReg;
    }

    public void setDateReg(LocalDate dateReg) {
        this.dateReg = dateReg;
    }


}
