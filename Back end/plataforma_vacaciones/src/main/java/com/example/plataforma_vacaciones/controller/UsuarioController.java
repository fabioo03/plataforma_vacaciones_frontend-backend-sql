package com.example.plataforma_vacaciones.controller;
import com.example.plataforma_vacaciones.percistence.entities.UsuarioEntity;
import com.example.plataforma_vacaciones.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }
    // link para ver una lista de todos los usuarios
    @GetMapping("/consultar")
    public List<UsuarioEntity> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
// link para crear un usuario
    @PostMapping("/crear")
    public UsuarioEntity crearUsuario(@RequestBody UsuarioEntity usuario){
    return usuarioService.crearUsuario(usuario);
    }
    // link para actualizar un usuario pendiente se debe de enviar el id del usuario
    @PutMapping("/actualizar{id}")
    public UsuarioEntity updateUsuario(@RequestBody UsuarioEntity usuario , @PathVariable  Long id){
        return usuarioService.updateUsuario(usuario,id);
    }
    // link para eliminar un usuario
    @DeleteMapping ("/eliminar")
    public  ResponseEntity<Void> deleteUsuario( @RequestBody UsuarioEntity usuario ){
         usuarioService.deleteUsuario(usuario);
         return new ResponseEntity<>(HttpStatus.OK);
    }
}
