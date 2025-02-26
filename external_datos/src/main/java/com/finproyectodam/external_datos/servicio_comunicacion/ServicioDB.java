package com.finproyectodam.external_datos.servicio_comunicacion;

import com.finproyectodam.external_datos.artistas.model.ArtistaDTO;
import com.finproyectodam.external_datos.usuarios.loginusuarios.model.LoginUsuariosDTO;
import com.finproyectodam.external_datos.usuarios.registrousuarios.model.RegistroUsuariosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Clase con el servicio de comunicación para el otro microservicio
 * @author cristian && Joel
 * @version 1.0
 */
@FeignClient(name = "relationaldb", url = ("http://localhost:8081"))
public interface ServicioDB {

    //metodos de usuarios

    /**
     * metodo post para registrar usuarios
     * @param registroUsuariosDTO el objeto usuario
     */
    @PostMapping("/relationaldb/spotify/registrousuarios")
    void registerUsers(@RequestBody RegistroUsuariosDTO registroUsuariosDTO);

    /**
     * metodo para iniciar sesion en spotify
     * @param loginUsuariosDTO el objeto usuario para el registro
     */
    @PostMapping("/relationaldb/spotify/loginusuarios")
    void loginUsuarios(@RequestBody LoginUsuariosDTO loginUsuariosDTO);

    //metodos de artistas

    @GetMapping("relationaldb/spotify/artistas/info/id/{id}")
    ArtistaDTO getArtistaById(@PathVariable Integer id);

    @GetMapping("/relationaldb/spotify/artistas/info/nombre/{nombre}")
    ArtistaDTO getArtistaByNombre(@PathVariable String nombre);

    @GetMapping("/relationaldb/spotify/artistas/info/genero/{generi}")
    List<ArtistaDTO> getArtistaByGenero(@PathVariable String generi);


}
