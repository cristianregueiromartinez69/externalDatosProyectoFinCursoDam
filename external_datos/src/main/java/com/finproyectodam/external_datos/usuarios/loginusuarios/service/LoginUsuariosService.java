package com.finproyectodam.external_datos.usuarios.loginusuarios.service;

import com.finproyectodam.external_datos.model.TokenDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import com.finproyectodam.external_datos.usuarios.loginusuarios.model.LoginUsuariosDTO;
import org.springframework.stereotype.Service;

/**
 * Servicio de login de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class LoginUsuariosService {

    private final ServicioDB servicioDB;
    private final TokenDTO tokenDTO;

    /**
     * Constructor de la clase
     * @param servicioDB el servicio a mandar al otro microservicio
     */
    public LoginUsuariosService(ServicioDB servicioDB, TokenDTO tokenDTO) {
        this.servicioDB = servicioDB;
        this.tokenDTO = tokenDTO;
    }

    //metodo para mandar los datos de registro
    public String loginUser(LoginUsuariosDTO loginUsuariosDTO) {
        servicioDB.loginUsuarios(loginUsuariosDTO);
        return tokenDTO.getToken();
    }
}
