package com.finproyectodam.external_datos.servicio_comunicacion;

import com.finproyectodam.external_datos.registrousuarios.model.RegistroUsuariosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
