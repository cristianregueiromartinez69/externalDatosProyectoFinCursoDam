package com.finproyectodam.external_datos.usuarios.loginusuarios.service;

import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioMongo;
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
    private final ServicioMongo servicioMongo;

    /**
     * Constructor de la clase
     * @param servicioDB el servicio a mandar al otro microservicio
     */
    public LoginUsuariosService(ServicioDB servicioDB, ServicioMongo servicioMongo) {
        this.servicioDB = servicioDB;
        this.servicioMongo = servicioMongo;
    }

    //metodo para mandar los datos de registro
    public void loginUser(LoginUsuariosDTO loginUsuariosDTO) {
        servicioDB.loginUsuarios(loginUsuariosDTO);
        servicioMongo.loginUsuariosMongo(loginUsuariosDTO);
    }
}
