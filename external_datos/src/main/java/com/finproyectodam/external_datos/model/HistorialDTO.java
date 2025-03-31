package com.finproyectodam.external_datos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HistorialDTO {

    @JsonIgnore
    private String id;

    private Integer idCancion;

    @JsonIgnore
    private String emailUser;

    @JsonIgnore
    private LocalDate fechaRegistro;

    public HistorialDTO(String id, Integer idCancion, String emailUser, LocalDate fechaRegistro) {
        this.id = id;
        this.idCancion = idCancion;
        this.emailUser = emailUser;
        this.fechaRegistro = fechaRegistro;
    }

    public HistorialDTO() {

    }

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
