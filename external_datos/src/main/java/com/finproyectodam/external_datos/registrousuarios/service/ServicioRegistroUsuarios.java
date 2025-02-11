package com.finproyectodam.external_datos.registrousuarios.service;

import com.finproyectodam.external_datos.registrousuarios.excepciones.EmailException;
import com.finproyectodam.external_datos.registrousuarios.excepciones.PasswordException;
import com.finproyectodam.external_datos.registrousuarios.excepciones.UserNameException;
import com.finproyectodam.external_datos.registrousuarios.model.RegistroUsuariosDTO;
import com.finproyectodam.external_datos.registrousuarios.service.comprobaciones.ComprobacionesEmail;
import com.finproyectodam.external_datos.registrousuarios.service.comprobaciones.ComprobacionesPassword;
import com.finproyectodam.external_datos.registrousuarios.service.comprobaciones.ComprobacionesUserName;
import com.finproyectodam.external_datos.servicio_comunicacion.ServicioDB;
import org.springframework.stereotype.Service;

/**
 * Clase servicio que hace la lógica de registro de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class ServicioRegistroUsuarios {

    private final ServicioDB servicioDB;

    /**
     * Constructor que inyecta dependencias del servicio de comunicacion
     * @param servicioDB ña interfaz con el servicio de comunicacion
     */
    public ServicioRegistroUsuarios(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }


    /**
     * Metodo que manda la información del usuario a la base de datos
     * @param registroUsuariosDTO el usuario registrado
     * @throws UserNameException la excecpion del alias
     * @throws EmailException la excepcion del email
     * @throws PasswordException la excepcion de la contraseña
     */
    public void registerUsuariosService(RegistroUsuariosDTO registroUsuariosDTO) throws UserNameException, EmailException, PasswordException {
        ComprobacionesUserName comrpUser = new ComprobacionesUserName();
        ComprobacionesEmail comrpEmail = new ComprobacionesEmail();
        ComprobacionesPassword comrpPassword = new ComprobacionesPassword();

        if(!comrpUser.authenticationRegisterName(registroUsuariosDTO.getUsername())){
            throw new UserNameException("Username incorrecto, introduce otro");
        }
        else if(!comrpEmail.authenticationRegisterEmail(registroUsuariosDTO.getEmail())){
            throw new EmailException("Correo incorrecto, introduce otro");
        }
        else if(!comrpPassword.authenticationRegisterPassword(registroUsuariosDTO.getPasswordU())){
            throw new PasswordException("contraseña mal introducida, introduce otro");
        }
        else{
            RegistroUsuariosDTO registroUsuariosDTO1 = new RegistroUsuariosDTO(registroUsuariosDTO.getUsername(), registroUsuariosDTO.getEmail(), registroUsuariosDTO.getPasswordU(), registroUsuariosDTO.getDateReg());

            servicioDB.registerUsers(registroUsuariosDTO1);
        }
    }






}
