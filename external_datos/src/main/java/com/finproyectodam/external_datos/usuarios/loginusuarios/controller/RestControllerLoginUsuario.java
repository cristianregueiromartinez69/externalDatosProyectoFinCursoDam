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

@RestController
@RequestMapping("/spotify/usuarios")
public class RestControllerLoginUsuario {

    private final LoginUsuariosService loginUsuariosService;

    public RestControllerLoginUsuario(LoginUsuariosService loginUsuariosService) {
        this.loginUsuariosService = loginUsuariosService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuariosController(@RequestBody LoginUsuariosDTO loginUsuariosDTO) {
        try{
            loginUsuariosService.loginUser(loginUsuariosDTO);
        }catch (FeignException fe){
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fe.getMessage());
            }
        }
        return ResponseEntity.ok("Inicio de sesión de usuario correcto");
    }
}
