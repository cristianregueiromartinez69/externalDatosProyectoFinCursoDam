package com.finproyectodam.external_datos.registrousuarios.controller;

import com.finproyectodam.external_datos.registrousuarios.excepciones.UserNameException;
import com.finproyectodam.external_datos.registrousuarios.model.RegistroUsuariosDTO;
import com.finproyectodam.external_datos.registrousuarios.service.ServicioRegistroUsuarios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spotify/")
public class RegistroUsuariosRestController {

    private final ServicioRegistroUsuarios servicioRegistroUsuarios;

    public RegistroUsuariosRestController(ServicioRegistroUsuarios servicioRegistroUsuarios) {
        this.servicioRegistroUsuarios = servicioRegistroUsuarios;
    }

    @PostMapping("registrousuarios")
    public ResponseEntity<String> registroUsuariosSpotify(@RequestBody RegistroUsuariosDTO registroUsuariosDTO) {
        try{
            servicioRegistroUsuarios.registerUsuariosService(registroUsuariosDTO);
            return ResponseEntity.ok("Usuario registrado correctamente");
        }catch(UserNameException e){
            return new ResponseEntity<>("formato de nombre incorrecto, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        }
    }
}
