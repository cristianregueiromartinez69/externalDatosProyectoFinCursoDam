package com.finproyectodam.external_datos.registrousuarios.controller;


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

/**
 * Controlador encargado de gestionar el registro de usuarios en la plataforma Spotify.
 * Proporciona un endpoint para registrar nuevos usuarios con los datos enviados en formato DTO.
 * @author cristian && Joel
 * version 1.0
 */
@RestController
@RequestMapping("/spotify/usuarios")
public class RegistroUsuariosRestController {


    private final ServicioRegistroUsuarios servicioRegistroUsuarios;

    /**
     * Constructor del controlador. Inyecta el servicio de registro de usuarios.
     *
     * @param servicioRegistroUsuarios El servicio encargado de registrar usuarios.
     */
    public RegistroUsuariosRestController(ServicioRegistroUsuarios servicioRegistroUsuarios) {
        this.servicioRegistroUsuarios = servicioRegistroUsuarios;
    }

    /**
     * Endpoint para registrar un nuevo usuario en Spotify. Recibe un objeto DTO con los datos del usuario,
     * y valida el formato de los datos. En caso de error, devuelve una respuesta con el código HTTP adecuado.
     *
     * @param registroUsuariosDTO El objeto DTO que contiene los datos del usuario a registrar.
     * @return ResponseEntity con el mensaje y el estado HTTP correspondiente.
     */
    @PostMapping("/registro")
    public ResponseEntity<String> registroUsuariosSpotify(@RequestBody RegistroUsuariosDTO registroUsuariosDTO) {
        try {

            //llamanos al servicio para registrar al usuario
            servicioRegistroUsuarios.registerUsuariosService(registroUsuariosDTO);

            //excepciones controladas
        } catch (UserNameException nombreException) {
            return new ResponseEntity<>("formato de nombre incorrecto, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        } catch (EmailException emailException) {
            return new ResponseEntity<>("Formato de email incorrecto, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        } catch (PasswordException passEx) {
            return new ResponseEntity<>("Formato contraseña erroneo, debe ser de 12 o más carácteres, llevar mínimo 1 numero y 1 carácter especial, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        }} catch (FeignException fe) {
    if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fe.getMessage());
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error externo al registrar el usuario.");
    }
}
// si todo va bien, el usuario está registrado
return ResponseEntity.ok("Usuario registrado correctamente");

    }
}
