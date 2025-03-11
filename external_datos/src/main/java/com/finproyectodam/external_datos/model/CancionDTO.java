package com.finproyectodam.external_datos.model;


import lombok.Data;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de canciones
 * @author cristian && joel
 * @version 1.0
 */
public class CancionDTO {

    //atributos de clase
    private Integer id;
    private String titulo;
    private Integer duracion;
    private String urlcancion;
    private ArtistaDTO artistaid;
    private AlbumDTO albumid;
    private Set<PlayListDTO> playlists = new LinkedHashSet<>();

    /**
     * Contructor de la clase
     * @param titulo el titulo de la cancion
     * @param duracion la duracion de la cancion
     * @param urlcancion la url de la cancion
     * @param artistaid el artista de la cancion
     * @param albumid el album de la cancion
     * @param playlists la playlist de la cancion
     */
    public CancionDTO(Integer id, String titulo, Integer duracion, String urlcancion, ArtistaDTO artistaid, AlbumDTO albumid, Set<PlayListDTO> playlists) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.urlcancion = urlcancion;
        this.artistaid = artistaid;
        this.albumid = albumid;
        this.playlists = playlists;
    }

    public CancionDTO(String titulo, Integer duracion, String urlcancion) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.urlcancion = urlcancion;
    }

    public CancionDTO() {
    }

    //getter y setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getUrlcancion() {
        return urlcancion;
    }

    public void setUrlcancion(String urlcancion) {
        this.urlcancion = urlcancion;
    }

    public ArtistaDTO getArtistaid() {
        return artistaid;
    }

    public void setArtistaid(ArtistaDTO artistaid) {
        this.artistaid = artistaid;
    }

    public AlbumDTO getAlbumid() {
        return albumid;
    }

    public void setAlbumid(AlbumDTO albumid) {
        this.albumid = albumid;
    }

    public Set<PlayListDTO> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<PlayListDTO> playlists) {
        this.playlists = playlists;
    }
}
