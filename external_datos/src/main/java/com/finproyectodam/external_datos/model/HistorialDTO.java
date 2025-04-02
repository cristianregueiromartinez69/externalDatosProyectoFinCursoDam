package com.finproyectodam.external_datos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

/**
 * Clase historial de DTO para recibir el historial
 * @author cristian && Joel
 * @version 1.0
 */
public class HistorialDTO {

    //atributos de clase
    private String id;

    private Integer idCancion;

    private String emailUser;

    @JsonIgnore
    private LocalDate fechaRegistro;

    /**
     * Constructor de la clase
     * @param id la clave primaria
     * @param idCancion el id de la cancion
     * @param emailUser el email del usuario
     * @param fechaRegistro la fecha de registro
     */
    public HistorialDTO(String id, Integer idCancion, String emailUser, LocalDate fechaRegistro) {
        this.id = id;
        this.idCancion = idCancion;
        this.emailUser = emailUser;
        this.fechaRegistro = fechaRegistro;
    }

    public HistorialDTO() {

    }

    //getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
