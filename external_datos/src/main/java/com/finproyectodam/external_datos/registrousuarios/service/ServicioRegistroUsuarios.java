package com.finproyectodam.external_datos.registrousuarios.service;

import com.finproyectodam.external_datos.registrousuarios.excepciones.EmailException;
import com.finproyectodam.external_datos.registrousuarios.excepciones.UserNameException;
import com.finproyectodam.external_datos.registrousuarios.model.RegistroUsuariosDTO;
import com.finproyectodam.external_datos.registrousuarios.service.comprobaciones.ComprobacionesEmail;
import com.finproyectodam.external_datos.registrousuarios.service.comprobaciones.ComprobacionesUserName;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

@Service
public class ServicioRegistroUsuarios {

    private final ServicioDB servicioDB;

    public ServicioRegistroUsuarios(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }


    public void registerUsuariosService(RegistroUsuariosDTO registroUsuariosDTO) throws UserNameException{
        ComprobacionesUserName comrpUser = new ComprobacionesUserName();
        ComprobacionesEmail comrpEmail = new ComprobacionesEmail();

        if(!comrpUser.authenticationRegisterName(registroUsuariosDTO.getUserName())){
            throw new UserNameException("Username incorrecto, introduce otro");
        }
        else if(comrpEmail.authenticationRegisterEmail(registroUsuariosDTO.getCorreo())){
            throw new EmailException("Correo incorrecto, introduce otro");
        }
        else{
            servicioDB.registerUsers(registroUsuariosDTO);
        }
    }






}
