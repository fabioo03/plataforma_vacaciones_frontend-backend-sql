package com.example.plataforma_vacaciones.controller;


import com.example.plataforma_vacaciones.percistence.entities.EmpleadoEntity;
import com.example.plataforma_vacaciones.percistence.entities.EquipoEntity;
import com.example.plataforma_vacaciones.service.EmpleadoService;
import com.example.plataforma_vacaciones.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipo")
@CrossOrigin(origins = "http://localhost:4200") // para que apunte a la url
public class EquipoController {


    private EquipoService  equipoService;

    @Autowired
    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    // link de consulta de todos los empleados
    @RequestMapping("/consultar")
    public List<EquipoEntity> getAllEquipo(){
        return equipoService.getAllEquipo();
    }




}
