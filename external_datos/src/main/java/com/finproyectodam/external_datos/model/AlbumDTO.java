package com.finproyectodam.external_datos.model;



import java.util.LinkedHashSet;
import java.util.Set;

public class AlbumDTO {




    private String titulo;


    private Integer anolanz;


    private ArtistaDTO artistaid;

    private Set<CancionDTO> canciones = new LinkedHashSet<>();

    public AlbumDTO(String titulo, Integer anolanz, ArtistaDTO artistaid, Set<CancionDTO> canciones) {
        this.titulo = titulo;
        this.anolanz = anolanz;
        this.artistaid = artistaid;
        this.canciones = canciones;
    }

    public AlbumDTO(String titulo, Integer anolanz) {
        this.titulo = titulo;
        this.anolanz = anolanz;
    }

    public AlbumDTO() {
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnolanz() {
        return anolanz;
    }

    public void setAnolanz(Integer anolanz) {
        this.anolanz = anolanz;
    }

    public ArtistaDTO getArtistaid() {
        return artistaid;
    }

    public void setArtistaid(ArtistaDTO artistaid) {
        this.artistaid = artistaid;
    }

    public Set<CancionDTO> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<CancionDTO> canciones) {
        this.canciones = canciones;
    }
}
