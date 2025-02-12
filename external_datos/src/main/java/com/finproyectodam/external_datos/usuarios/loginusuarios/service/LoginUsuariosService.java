package com.finproyectodam.external_datos.usuarios.loginusuarios.service;

import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import com.finproyectodam.external_datos.usuarios.loginusuarios.model.LoginUsuariosDTO;
import org.springframework.stereotype.Service;

@Service
public class LoginUsuariosService {

    private final ServicioDB servicioDB;

    public LoginUsuariosService(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    public void loginUsuariosService(LoginUsuariosDTO loginUsuariosDTO) {
        servicioDB.loginUsuarios(loginUsuariosDTO);
    }
}
