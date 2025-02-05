package com.finproyectodam.external_datos.registrousuarios.model;

import java.time.LocalDate;

public class RegistroUsuariosDTO {

    private String userName;
    private String correo;
    private String password;
    private LocalDate dateReg;

    public RegistroUsuariosDTO(String userName, String correo, String password, LocalDate dateReg) {
        this.userName = userName;
        this.correo = correo;
        this.password = password;
        this.dateReg = dateReg;
    }

    public RegistroUsuariosDTO() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateReg() {
        return dateReg;
    }

    public void setDateReg(LocalDate dateReg) {
        this.dateReg = dateReg;
    }


}
