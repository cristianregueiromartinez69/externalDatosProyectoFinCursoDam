package com.finproyectodam.external_datos.servicio_comunicacion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "MongoProyectoFinDam", url = ("http://localhost:8082"))
public interface ServicioMongo {

    /**
     * Metodo para cuando el usuario escuche una cancion, se guarde en un historial
     * @param idCancion el id de la cancion
     */
    @PostMapping("/relationaldb/spotify/canciones/play/id/{idCancion}")
    void saveCancionHistorial(@PathVariable Integer idCancion);
}
