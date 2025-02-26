package com.finproyectodam.external_datos.model;



import java.util.LinkedHashSet;
import java.util.Set;

public class ArtistaDTO {




    private String nameart;


    private String generoMusc;


    private String descrip;


    private Set<AlbumDTO> albumes = new LinkedHashSet<>();


    private Set<CancionDTO> canciones = new LinkedHashSet<>();


    public ArtistaDTO(String nameart, String generoMusc, String descrip, Set<AlbumDTO> albumes, Set<CancionDTO> canciones) {
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
