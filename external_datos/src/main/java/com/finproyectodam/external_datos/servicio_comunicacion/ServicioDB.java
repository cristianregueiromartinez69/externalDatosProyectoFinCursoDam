package com.finproyectodam.external_datos.servicio_comunicacion;

import com.finproyectodam.external_datos.model.AlbumDTO;
import com.finproyectodam.external_datos.model.ArtistaDTO;
import com.finproyectodam.external_datos.usuarios.loginusuarios.model.LoginUsuariosDTO;
import com.finproyectodam.external_datos.usuarios.registrousuarios.model.RegistroUsuariosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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


    /**
     * Metodo para obtener un artista por el id
     * @param id el id del artista
     * @return el artista
     */
    @GetMapping("/relationaldb/spotify/artistas/info/id/{id}")
    ArtistaDTO getArtistaById(@PathVariable Integer id);

    /**
     * Metodo para buscar a un artista por su nombre
     * @param nombre el nombre del artista
     * @return el artista
     */
    @GetMapping("/relationaldb/spotify/artistas/info/nombre/{nombre}")
    ArtistaDTO getArtistaByNombre(@PathVariable String nombre);

    /**
     * Metodo para buscar a una lista de artistas por el genero musical
     * @param generi el genero musical
     * @return la lista de artistas
     */
    @GetMapping("/relationaldb/spotify/artistas/info/genero/{generi}")
    List<ArtistaDTO> getArtistaByGenero(@PathVariable String generi);

    /**
     * Metodo para obtener un album por el id
     * @param id el id del album
     * @return el album o null
     */
    @GetMapping("/relationaldb/spotify/albumes/info/id/{id}")
    AlbumDTO getAlbumById(@PathVariable Integer id);

    /**
     * Metodo para obtener un album por el titulo
     * @param titulo el titulo del album
     * @return el album o null
     */
    @GetMapping("/relationaldb/spotify/albumes/info/titulo/{titulo}")
    AlbumDTO getAlbumByTitulo(@PathVariable String titulo);

    /**
     * Metodo para obtener una lista de albumes entre años de lanzamiento
     * @param anoInicio el año de inicio
     * @param anoFin el año de fin
     * @return una lista de albumes o null
     */
    @GetMapping("/relationaldb/spotify/albumes/info/anolanz")
    List<AlbumDTO> getListAlbumByAnoLanz(@RequestParam("anoInit") Integer anoInicio,
                                         @RequestParam("anoFin") Integer anoFin);

}
