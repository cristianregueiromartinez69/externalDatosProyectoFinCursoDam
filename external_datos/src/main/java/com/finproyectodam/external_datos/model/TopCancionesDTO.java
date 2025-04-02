package com.finproyectodam.external_datos.model;

/**
 * DTO de top canciones de spotify
 * @author cristian && Joel
 * @author cristian
 */
public class TopCancionesDTO {

    //atributos de clase
    private String id;
    private Integer idCancion;
    private Integer vecesEscuchada;

    /**
     * Cosntructor de la clase
     * @param id clave primaria
     * @param idCancion el id de la cancion
     * @param vecesEscuchada las veces que ha sido escuchada
     */
    public TopCancionesDTO(String id, Integer idCancion, Integer vecesEscuchada) {
        this.id = id;
        this.idCancion = idCancion;
        this.vecesEscuchada = vecesEscuchada;
    }

    public TopCancionesDTO(Integer idCancion, Integer vecesEscuchada) {
        this.idCancion = idCancion;
        this.vecesEscuchada = vecesEscuchada;
    }

    public TopCancionesDTO() {
    }

    //getter y setter
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

    public Integer getVecesEscuchada() {
        return vecesEscuchada;
    }

    public void setVecesEscuchada(Integer vecesEscuchada) {
        this.vecesEscuchada = vecesEscuchada;
    }
}
