package com.finproyectodam.external_datos.model;


import lombok.Data;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de playlist
 * @author cristian && joel
 * @version 1.0
 */
public class PlayListDTO {

    //atributos de clase
    private String titulo;
    private LocalDate fechacre;
    private String descrip;
    private UsuarioDTO userid;
    private Set<CancionDTO> canciones = new LinkedHashSet<>();

    /**
     * Constructor de la clase
     * @param titulo el titulo de la playlist
     * @param fechacre la fecha de creacion de la playlist
     * @param descrip la descripcion de la playlist
     * @param userid el usuario al que pertenece la playlist
     * @param canciones las canciones que tiene la playlist
     */
    public PlayListDTO(String titulo, LocalDate fechacre, String descrip, UsuarioDTO userid, Set<CancionDTO> canciones) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
        this.userid = userid;
        this.canciones = canciones;
    }

    public PlayListDTO(String titulo, LocalDate fechacre, String descrip, UsuarioDTO userid) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
        this.userid = userid;
    }

    public PlayListDTO(String titulo, LocalDate fechacre, String descrip) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
    }

    public PlayListDTO() {

    }

    //getter y setter
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
