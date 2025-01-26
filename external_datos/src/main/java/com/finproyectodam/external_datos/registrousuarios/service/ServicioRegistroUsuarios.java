package com.finproyectodam.external_datos.registrousuarios.service;

import com.finproyectodam.external_datos.registrousuarios.model.RegistroUsuariosDTO;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioRegistroUsuarios {

    private final ServicioDB servicioDB;

    public ServicioRegistroUsuarios(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }


    public void registerUsuariosService(RegistroUsuariosDTO registroUsuariosDTO){
        servicioDB.registerUsers(registroUsuariosDTO);
    }


}
