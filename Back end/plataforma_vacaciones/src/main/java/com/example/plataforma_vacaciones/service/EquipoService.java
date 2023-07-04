package com.example.plataforma_vacaciones.service;


import com.example.plataforma_vacaciones.percistence.entities.EmpleadoEntity;
import com.example.plataforma_vacaciones.percistence.entities.EquipoEntity;
import com.example.plataforma_vacaciones.percistence.repository.EmpleadoRepository;
import com.example.plataforma_vacaciones.percistence.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    private static EquipoRepository equiporepository;

    @Autowired
    public EquipoService(EquipoRepository equiporepository) {
        this.equiporepository = equiporepository;
    }

    // nos traemos todos los empleados que estan creados en la base de datos
    public List<EquipoEntity> getAllEquipo(){
        try {
            return equiporepository.findAll();
        }    catch (Exception e){
            System.err.println("Error al intentar obtener todos los empleados:"+e);
            return null;
        }
    }







}
