package com.finproyectodam.external_datos.model;



import lombok.Data;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de albumes
 * @author cristian && joel
 * @version 1.0
 */
public class AlbumDTO {

    //atributos de clase
    private String titulo;
    private Integer anolanz;
    private ArtistaDTO artistaid;
    private Set<CancionDTO> canciones = new LinkedHashSet<>();


    /**
     * Constructor de la clase
     * @param titulo el titulo del album
     * @param anolanz el año de lanzamiento del album
     * @param artistaid el artista del album
     * @param canciones las canciones del album
     */
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

    //getter y setter
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
