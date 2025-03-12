package com.finproyectodam.external_datos.model;


import java.time.LocalDate;
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


    /**
     * Constructor de la clase
     * @param titulo el titulo de la playlist
     * @param fechacre la fecha de creacion de la playlist
     * @param descrip la descripcion de la playlist
     */
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


}
