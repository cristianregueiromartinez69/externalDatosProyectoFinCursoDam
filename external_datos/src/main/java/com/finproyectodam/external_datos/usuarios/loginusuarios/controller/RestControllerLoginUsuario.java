package com.finproyectodam.external_datos.usuarios.loginusuarios.controller;

import com.finproyectodam.external_datos.usuarios.loginusuarios.model.LoginUsuariosDTO;
import com.finproyectodam.external_datos.usuarios.loginusuarios.service.LoginUsuariosService;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController de envio de datos de login de usuario a la base de datos
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/spotify/usuarios")
public class RestControllerLoginUsuario {

    private final LoginUsuariosService loginUsuariosService;

    /**
     * Constructor de la clase
     * @param loginUsuariosService el servicio de login de usuarios
     */
    public RestControllerLoginUsuario(LoginUsuariosService loginUsuariosService) {
        this.loginUsuariosService = loginUsuariosService;
    }

    /**
     * Metodo para autenticar al usuario para el login
     * @param loginUsuariosDTO el objeto de login de usuario
     * @return confirmación o negación del login
     */
    @PostMapping("/login")
    public ResponseEntity<String> loginUsuariosController(@RequestBody LoginUsuariosDTO loginUsuariosDTO) {
        try{
            String token = loginUsuariosService.loginUser(loginUsuariosDTO);
            return ResponseEntity.ok("Inicio de sesión de usuario correcto " + token);
        }catch (FeignException fe){
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fe.getMessage());
            }
            else if(fe.status() == HttpStatus.UNAUTHORIZED.value()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(fe.getMessage());
            }
        }
       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
