package com.finproyectodam.external_datos.playlist.controller;

import com.finproyectodam.external_datos.model.PlayListDTO;
import com.finproyectodam.external_datos.playlist.service.PlayListService;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Restcontroller de las playlist
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/spotify/playlist")
public class PlayListController {

    private final PlayListService playListService;

    /**
     * Constructor del restController de las playlist
     * @param playListService el servicio de playList
     */
    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    /**
     * metodo Post para la creación de una playlist
     * @param playListDTO la playlist a crear
     * @return un mensaje indicando si se creo o no
     */
    @PostMapping("/crear")
    public ResponseEntity<String> createNewPlayListController(@RequestBody PlayListDTO playListDTO) {
        try{
            playListService.createNewPlayListService(playListDTO);
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fe.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.ok("PlayList creada correctamente");
    }

    /**
     * Metodo post para añadir canciones a la playlist
     * @param playlistId el id de la playlist
     * @param cancionId el id de la cacion
     * @return un mensaje diciendo de si se añadio o no la cancion
     */
    @PostMapping("/{playlistId}/cancion/{cancionId}")
    public ResponseEntity<String> addnewCancionPlaylistController(@PathVariable Integer playlistId,
                                                                  @PathVariable Integer cancionId){
        try{
            playListService.addNewPlaylistCancionService(playlistId, cancionId);
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fe.getMessage());
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.ok("Cancion añadida a la playlist");
    }

    /**
     * Metodo get para obtener todas las playlist del usuario al entrar
     * @return la lista de playlist
     */
    @GetMapping("/info")
    public ResponseEntity<List<PlayListDTO>> getPlayListController(){
        try{
            List<PlayListDTO> playListDTOList = playListService.getAllPlayListsService();
            return ResponseEntity.ok(playListDTOList);
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(null);
    }

    /**
     * metodo get que obtiene una playlist por el id
     * @param id el id de la playlist
     * @return el objeto playlist
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<PlayListDTO> getPlayListByIdController(@PathVariable Integer id){
        try{
            PlayListDTO playListDTO = playListService.getPlayListById(id);
            return ResponseEntity.ok(playListDTO);
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }
        return ResponseEntity.ok(null);
    }

    /**
     * Metodo deleteMapping que borra una playlist por id
     * @param id el id de la playlist a borrar
     * @return un mensaje descriptivo del mismo
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlayListByIdController(@PathVariable Integer id){
        try{
            playListService.deletePlayListById(id);
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fe.getMessage());
            }
        }
        return ResponseEntity.ok("PlayList eliminada correctamente");
    }

    /**
     * Metodo de eliminacion de cancion de la playlist
     * @param playlistId el id de la playlits
     * @param cancionId el id de la cancion de la playlist
     * @return un mensaje indicando si se elimino la cancion o no
     */
    @DeleteMapping("/delete/{playlistId}/cancion/{cancionId}")
    public ResponseEntity<String> deleteSongPlaylistByIdController(@PathVariable Integer playlistId, @PathVariable Integer cancionId){
        try{
            playListService.deleteSongPlaylistById(playlistId, cancionId);
        }catch (FeignException fe) {
            if (fe.status() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fe.getMessage());
            }
        }
        return ResponseEntity.ok("Cancion de la playlist eliminada correctamente");
    }

}
