package com.finproyectodam.external_datos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de artistas
 * @author cristian && joel
 * @version 1.0
 */

public class ArtistaDTO {

    //atributos de clase
    private Integer id;
    private String nameart;
    private String generoMusc;
    private String descrip;

    @JsonManagedReference("artista_albumes")
    private Set<AlbumDTO> albumes = new LinkedHashSet<>();

    @JsonManagedReference("artista_canciones")
    private Set<CancionDTO> canciones = new LinkedHashSet<>();


    /**
     * Constructor de la clase
     * @param nameart el nombre del artista
     * @param generoMusc el genero musical del artista
     * @param descrip la descripcion del artista
     * @param albumes los albumes del artista
     * @param canciones las canciones del artista
     */
    public ArtistaDTO(Integer id, String nameart, String generoMusc, String descrip, Set<AlbumDTO> albumes, Set<CancionDTO> canciones) {
        this.id = id;
        this.nameart = nameart;
        this.generoMusc = generoMusc;
        this.descrip = descrip;
        this.albumes = albumes;
        this.canciones = canciones;
    }

    public ArtistaDTO(String nameart, String generoMusc, String descrip) {
        this.nameart = nameart;
        this.generoMusc = generoMusc;
        this.descrip = descrip;
    }

    public ArtistaDTO() {
    }


    //getter y setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameart() {
        return nameart;
    }

    public void setNameart(String nameart) {
        this.nameart = nameart;
    }

    public String getGeneroMusc() {
        return generoMusc;
    }

    public void setGeneroMusc(String generoMusc) {
        this.generoMusc = generoMusc;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Set<AlbumDTO> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(Set<AlbumDTO> albumes) {
        this.albumes = albumes;
    }

    public Set<CancionDTO> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<CancionDTO> canciones) {
        this.canciones = canciones;
    }
}
