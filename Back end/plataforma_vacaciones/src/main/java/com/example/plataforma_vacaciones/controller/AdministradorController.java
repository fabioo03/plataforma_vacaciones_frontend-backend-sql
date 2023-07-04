package com.example.plataforma_vacaciones.controller;
import com.example.plataforma_vacaciones.percistence.entities.AdministradorEntity;
import com.example.plataforma_vacaciones.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    private AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {

        this.administradorService = administradorService;
    }

    // para ver los usuarios
    @GetMapping("/consultar")
    public List<AdministradorEntity> getAllAdministrador(){
        return administradorService.getAllAdministrador();
    }

    // crear
    @PostMapping("/crear")
    public AdministradorEntity crearAdministrador(@RequestBody AdministradorEntity administrador){
        return administradorService.crearAdministrador(administrador);
    }

    // actualizar
    @PutMapping("/actualizar{id}")
    public AdministradorEntity updateAdministrador(@RequestBody AdministradorEntity administrador , @PathVariable  Long id){
        return administradorService.updateAdministrador(administrador,id);
    }

    //eliminar
    @DeleteMapping ("/eliminar")
    public  ResponseEntity<Void> deleteAdministrador( @RequestBody AdministradorEntity administrador ){
        administradorService.deleteAdministrador(administrador);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
