package com.finproyectodam.external_datos.model;


import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class PlayListDTO {


    private String titulo;


    private LocalDate fechacre;


    private String descrip;


    private UsuarioDTO userid;

    private Set<CancionDTO> canciones = new LinkedHashSet<>();

    public PlayListDTO(String titulo, LocalDate fechacre, String descrip, UsuarioDTO userid, Set<CancionDTO> canciones) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
        this.userid = userid;
        this.canciones = canciones;
    }

    public PlayListDTO(String titulo, LocalDate fechacre, String descrip) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechacre() {
        return fechacre;
    }

    public void setFechacre(LocalDate fechacre) {
        this.fechacre = fechacre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public UsuarioDTO getUserid() {
        return userid;
    }

    public void setUserid(UsuarioDTO userid) {
        this.userid = userid;
    }

    public Set<CancionDTO> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<CancionDTO> canciones) {
        this.canciones = canciones;
    }
}
