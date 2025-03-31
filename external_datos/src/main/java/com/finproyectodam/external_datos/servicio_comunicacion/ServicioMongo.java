package com.finproyectodam.external_datos.servicio_comunicacion;

import com.finproyectodam.external_datos.model.HistorialDTO;
import com.finproyectodam.external_datos.usuarios.loginusuarios.model.LoginUsuariosDTO;
import com.finproyectodam.external_datos.usuarios.registrousuarios.model.RegistroUsuariosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "MongoProyectoFinDam", url = ("http://localhost:8082"))
public interface ServicioMongo {

    /**
     * metodo post para registrar usuarios en mongo
     * @param registroUsuariosDTO el objeto usuario
     */
    @PostMapping("/MongoProyectoFinDam/spotify/registrousuarios")
    void registerUsersMongo(@RequestBody RegistroUsuariosDTO registroUsuariosDTO);

    /**
     * metodo para iniciar sesion en spotify para mongo
     * @param loginUsuariosDTO el objeto usuario para el registro
     */
    @PostMapping("/MongoProyectoFinDam/spotify/loginusuarios")
    void loginUsuariosMongo(@RequestBody LoginUsuariosDTO loginUsuariosDTO);

    /**
     * Metodo para cuando el usuario escuche una cancion, se guarde en un historial
     * @param idCancion el id de la cancion
     */
    @PostMapping("/MongoProyectoFinDam/spotify/canciones/play/id/{idCancion}")
    void saveCancionHistorial(@PathVariable Integer idCancion);

    /**
     * Metodo para obtener el historial de canciones de mongo
     * @return una lista de historiales
     */
    @GetMapping("/MongoProyectoFinDam/spotify/historial")
    List<HistorialDTO> getAllHistorial();

    /**
     * Metodo que borra un objeto historial por id
     * @param idCancion el id del historial
     */
    @DeleteMapping("/MongoProyectoFinDam/spotify/historial/borrar/id/{idCancion}")
    void borrarHistorialById(@PathVariable Integer idCancion);

    /**
     * Metodo para borrar el historial entero de un usuario
     */
    @DeleteMapping("/MongoProyectoFinDam/spotify/historial/borrar")
    void borrarTodoHistorial();

}
