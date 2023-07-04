package com.example.plataforma_vacaciones.controller;


import com.example.plataforma_vacaciones.percistence.entities.SolicitudEntity;
import com.example.plataforma_vacaciones.percistence.model.SolicitudDTO;
import com.example.plataforma_vacaciones.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
@CrossOrigin(origins = "http://localhost:4200") // para que apunte a la url
public class SolicitudController {
    private SolicitudService solicitudService;

    @Autowired
    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    // link para ver una lista de todos las solicitudes
    @GetMapping("/consultar")
    public List<SolicitudEntity> getAllSolicitud(){
        return solicitudService.getAllSolicitud();
    }

    // link para ver una lista de todos las solicitudes en orden de fecha mas reciente
    @GetMapping("/consultarFecha")
    public List<SolicitudEntity> getAllSolicitudFecha(){
        return solicitudService.SolicitudFecha();
    }

    // link para ver una lista de las solicitudes en orden de fecha mas reciente de un empleado especifico
    @GetMapping("/consultarFecha{id}")
    public List<SolicitudDTO> getAllSolicitudFechaId(@PathVariable Long id){
        return solicitudService.getAllSolicitudFechaId(id);
    }

    // link para crear una solicitud
    @PostMapping("/crear")
    public SolicitudEntity crearSolicitud(@RequestBody SolicitudEntity solicitud){
        return solicitudService.crearSolicitud(solicitud);
    }

    // link para actualizar una solicitud se le envia el id de la solicitud
    @PutMapping("/actualizar{id}")
    public SolicitudEntity updateSolicitud( @RequestBody SolicitudEntity solicitud, @PathVariable Long id){
        return solicitudService.updateSolicitud(solicitud,id);
    }

    // link para eliminar una solicitud
    @DeleteMapping ("/eliminar")
    public ResponseEntity<Void> deleteSolicitud(@RequestBody SolicitudEntity solicitud ){
        solicitudService.deleteSolicitud(solicitud);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
