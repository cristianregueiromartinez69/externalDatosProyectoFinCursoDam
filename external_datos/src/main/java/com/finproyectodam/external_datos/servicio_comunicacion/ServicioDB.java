package com.finproyectodam.external_datos.servicio_comunicacion;

import com.finproyectodam.external_datos.usuarios.loginusuarios.model.LoginUsuariosDTO;
import com.finproyectodam.external_datos.usuarios.registrousuarios.model.RegistroUsuariosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Clase con el servicio de comunicación para el otro microservicio
 * @author cristian && Joel
 * @version 1.0
 */
@FeignClient(name = "relationaldb", url = ("http://localhost:8081"))
public interface ServicioDB {


    /**
     * metodo post para registrar usuarios
     * @param registroUsuariosDTO el objeto usuario
     */
    @PostMapping("/relationaldb/spotify/registrousuarios")
    void registerUsers(@RequestBody RegistroUsuariosDTO registroUsuariosDTO);

    /**
     * metodo para iniciar sesion en spotify
     * @param loginUsuariosDTO el objeto usuario para el registro
     */
    @PostMapping("/relationaldb/spotify/loginusuarios")
    void loginUsuarios(@RequestBody LoginUsuariosDTO loginUsuariosDTO);


}
