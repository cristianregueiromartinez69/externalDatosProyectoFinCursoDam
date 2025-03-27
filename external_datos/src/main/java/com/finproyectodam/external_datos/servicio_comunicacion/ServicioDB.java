package com.finproyectodam.external_datos.servicio_comunicacion;

import com.finproyectodam.external_datos.model.AlbumDTO;
import com.finproyectodam.external_datos.model.ArtistaDTO;
import com.finproyectodam.external_datos.model.CancionDTO;
import com.finproyectodam.external_datos.model.PlayListDTO;
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

    //metodos de albumes

    /**
     * Metodo para obtener un album por el id
     * @param id el id del album
     * @return el album o null
     */
    @GetMapping("/relationaldb/spotify/albumes/info/id/{id}")
    AlbumDTO getAlbumById(@PathVariable Integer id);

    /**
     * Metodo para obtener un album o albumes por el titulo
     * @param titulo el titulo del album
     * @return la lista de albumes o album
     */
    @GetMapping("/relationaldb/spotify/albumes/info/titulo/{titulo}")
    List<AlbumDTO> getAlbumByTitulo(@PathVariable String titulo);

    /**
     * Metodo para obtener una lista de albumes entre años de lanzamiento
     * @param anoInicio el año de inicio
     * @param anoFin el año de fin
     * @return una lista de albumes o null
     */
    @GetMapping("/relationaldb/spotify/albumes/info/anolanz")
    List<AlbumDTO> getListAlbumByAnoLanz(@RequestParam("anoInit") Integer anoInicio,
                                         @RequestParam("anoFin") Integer anoFin);

    //metodos de playlist


    /**
     * Metodo para creaar playList
     * @param playListDTO la playlist a crear
     */
    @PostMapping("/relationaldb/spotify/playlist/crear")
    void createNewPlayList(@RequestBody PlayListDTO playListDTO);

    /**
     * Metodo para añadir canciones a la playlist
     * @param playlistId el id de la playlist
     * @param cancionId el id de la cancion
     */
    @PostMapping("/relationaldb/spotify/playlist/{playlistId}/cancion/{cancionId}")
    void addNewCancionesPlayList(@PathVariable Integer playlistId, @PathVariable Integer cancionId);

    /**
     * Metodo para recoger todas las playlist del usuario
     * @return una lista de playlist del usuario
     */
    @GetMapping("/relationaldb/spotify/playlist/info")
    List<PlayListDTO> getAllPlaylists();

    /**
     * Metodo que devuelve una playlist por id
     * @param id el id de la playlist
     * @return el objeto playlist
     */
    @GetMapping("/relationaldb/spotify/playlist/info/{id}")
    PlayListDTO getPlaylistById(@PathVariable Integer id);


    /**
     * Metodo para borrar tu playlist
     * @param id el id de la playlist
     */
    @DeleteMapping("/relationaldb/spotify/playlist/delete/{id}")
    void deletePlaylistById(@PathVariable Integer id);

    /**
     * Metodo para borrar canciones de la playlist
     * @param playlistId el id de la playlist
     * @param cancionId el id de la cancion a borrar
     */
    @DeleteMapping("/relationaldb/spotify/playlist/delete/{playlistId}/cancion/{cancionId}")
    void deleteCancionesPlayList(@PathVariable Integer playlistId, @PathVariable Integer cancionId);


    //metodos de canciones

    /**
     * Metodo para listar todas las canciones disponibles en spotify
     * @return una lista de canciones
     */
    @GetMapping("/relationaldb/spotify/canciones/info")
    List<CancionDTO> getAllCanciones();


    /**
     * Metodo obtener una cancion por su id
     * @param id el id de la cancion
     * @return el objeto cancion
     */
    @GetMapping("/relationaldb/spotify/canciones/info/id/{id}")
    CancionDTO getCancionById(@PathVariable Integer id);

    /**
     * Metodo para obtener una cancion o lista de canciones por mismo titulo
     * @param titulo el titulo de la cancion
     * @return la cancion o canciones
     */
    @GetMapping("/relationaldb/spotify/canciones/info/titulo/{titulo}")
    List<CancionDTO> getListCancionByTitulo(@PathVariable String titulo);

    //metodos random playlist y canciones

    /**
     * Metodo que al entrar en la pagina principal de spotify, te sale una playlist aleatoria
     * @return la playlist o una recomendada
     */
    @GetMapping("/relationaldb/spotify/inicio")
    PlayListDTO getInitPlaylistSpotify();

    /**
     * Metodo para cuando el usuario escuche una cancion, se guarde en un historial
     * @param idCancion el id de la cancion
     */
    @PostMapping("/relationaldb/spotify/canciones/play/id/{idCancion}")
    void saveCancionHistorial(@PathVariable Integer idCancion);
}
