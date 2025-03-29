package com.finproyectodam.external_datos.servicio_comunicacion;

import com.finproyectodam.external_datos.usuarios.loginusuarios.model.LoginUsuariosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MongoProyectoFinDam", url = ("http://localhost:8082"))
public interface ServicioMongo {

    /**
     * metodo para iniciar sesion en spotify para mongo
     * @param loginUsuariosDTO el objeto usuario para el registro
     */
    @PostMapping("/MongoProyectoFinDam/spotify/loginusuarios")
    void loginUsuarios(@RequestBody LoginUsuariosDTO loginUsuariosDTO);

    /**
     * Metodo para cuando el usuario escuche una cancion, se guarde en un historial
     * @param idCancion el id de la cancion
     */
    @PostMapping("/MongoProyectoFinDam/spotify/canciones/play/id/{idCancion}")
    void saveCancionHistorial(@PathVariable Integer idCancion);


}
