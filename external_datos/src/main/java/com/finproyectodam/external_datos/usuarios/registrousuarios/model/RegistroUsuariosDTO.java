package com.finproyectodam.external_datos.usuarios.registrousuarios.model;

import java.time.LocalDate;

/**
 * Modelo dto para mandarla al microservicio de la base de datos
 * @author cristian && Joel
 * @version 1.0
 */
public class RegistroUsuariosDTO {

    //variables de la clase
    private String username;
    private String email;
    private String passwordU;
    private LocalDate dateReg;

    /**
     * Constructores de la clase
     * @param userName el alias del usuario
     * @param correo el email del usuario
     * @param password la contraseña del usuario
     * @param dateReg la fecha de registro del usuario
     */
    public RegistroUsuariosDTO(String userName, String correo, String password, LocalDate dateReg) {
        this.username = userName;
        this.email = correo;
        this.passwordU = password;
        this.dateReg = dateReg;
    }

    public RegistroUsuariosDTO() {
    }


    /**
     * getter y setter de la clase
     * @return los atributos correspondientes
     */
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
