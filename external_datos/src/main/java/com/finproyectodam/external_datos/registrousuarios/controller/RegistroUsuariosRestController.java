package com.finproyectodam.external_datos.registrousuarios.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finproyectodam.external_datos.registrousuarios.excepciones.EmailException;
import com.finproyectodam.external_datos.registrousuarios.excepciones.PasswordException;
import com.finproyectodam.external_datos.registrousuarios.excepciones.UserNameException;
import com.finproyectodam.external_datos.registrousuarios.model.RegistroUsuariosDTO;
import com.finproyectodam.external_datos.registrousuarios.service.ServicioRegistroUsuarios;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spotify/usuarios")
public class RegistroUsuariosRestController {

    private final ServicioRegistroUsuarios servicioRegistroUsuarios;

    public RegistroUsuariosRestController(ServicioRegistroUsuarios servicioRegistroUsuarios) {
        this.servicioRegistroUsuarios = servicioRegistroUsuarios;
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registroUsuariosSpotify(@RequestBody RegistroUsuariosDTO registroUsuariosDTO) {
        try {
            servicioRegistroUsuarios.registerUsuariosService(registroUsuariosDTO);
        } catch (UserNameException nombreException) {
            return new ResponseEntity<>("formato de nombre incorrecto, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        } catch (EmailException emailException) {
            return new ResponseEntity<>("Formato de email incorrecto, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        } catch (PasswordException passEx) {
            return new ResponseEntity<>("Formato contraseña erroneo, debe ser de 12 o más carácteres, llevar mínimo 1 numero y 1 carácter especial, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        } catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fe.getMessage());
            }
        }
        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}
