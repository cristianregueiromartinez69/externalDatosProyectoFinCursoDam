package com.finproyectodam.external_datos.model;



import com.finproyectodam.external_datos.artistas.model.ArtistaDTO;

import java.util.LinkedHashSet;
import java.util.Set;

public class CancionDTO {




    private String titulo;


    private Integer duracion;


    private String urlcancion;

    private ArtistaDTO artistaid;


    private AlbumDTO albumid;


    private Set<PlayListDTO> playlists = new LinkedHashSet<>();

    public CancionDTO(String titulo, Integer duracion, String urlcancion, ArtistaDTO artistaid, AlbumDTO albumid, Set<PlayListDTO> playlists) {
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
