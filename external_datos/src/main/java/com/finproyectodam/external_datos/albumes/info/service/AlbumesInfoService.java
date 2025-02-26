package com.finproyectodam.external_datos.albumes.info.service;

import com.finproyectodam.external_datos.model.AlbumDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de logica de albumes
 * @author cristian && joel
 * @version 1.0
 */
@Service
public class AlbumesInfoService {

    //variable del servicio de comunicacion
    public final ServicioDB servicioDB;

    /**
     * Constructor de la clase
     * @param servicioDB el servicio de comunicacion
     */
    public AlbumesInfoService(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    /**
     * Metodo para obtener un album por id
     * @param id el id del album
     * @return el album o null
     */
    public AlbumDTO getAlbumByIdService(Integer id) {
        return servicioDB.getAlbumById(id);
    }

    /**
     * Metodo para obtener un album por titulo
     * @param titulo el titulo del album
     * @return el album o null
     */
    public AlbumDTO getAlbumByTituloService(String titulo){
        return servicioDB.getAlbumByTitulo(titulo);
    }

    /**
     * Metodo para obtener una lista de albumes entre años de lanzamiento
     * @param anoInit el año de inicio
     * @param anoFin el año de fin
     * @return una lista de albumes segun los años dados
     */
    public List<AlbumDTO> getAlbumesbetweenAnosLanz(Integer anoInit, Integer anoFin){
        return servicioDB.getListAlbumByAnoLanz(anoInit, anoFin);
    }


}
