package com.example.plataforma_vacaciones.controller;
import com.example.plataforma_vacaciones.percistence.entities.EmpleadoEntity;
import com.example.plataforma_vacaciones.percistence.model.EmpleadoDTO;
import com.example.plataforma_vacaciones.percistence.model.SolicitudDTO;
import com.example.plataforma_vacaciones.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "http://localhost:4200") // para que apunte a la url
public class EmpleadoController {

    private EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    // link de consulta de todos los empleados
    @RequestMapping("/consultar")
    public List<EmpleadoEntity> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    // link para crear un nuevo empleado
    @PostMapping("/crear")
    public EmpleadoEntity crearEmpleado(@RequestBody EmpleadoEntity empleado){

        return empleadoService.crearEmpleado(empleado);
    }

    // link para actualizar un empleado pendiente le debe de pasar el id
    @PutMapping("/actualizar{id}")
    public EmpleadoEntity updateEmpleado(@RequestBody EmpleadoEntity empleado, @PathVariable  Long id){
        return empleadoService.updateEmpleado(empleado,id);
    }

    // link para eliminar un empleado
    @DeleteMapping ("/eliminar")
    public ResponseEntity<Void> deleteEmpleado(@RequestBody EmpleadoEntity empleado ){
        empleadoService.deleteEmpleado(empleado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // otro
    @GetMapping("/consultar{id}")
    public List<EmpleadoDTO> getAllSolicitudFechaId(@PathVariable Long id){
        return EmpleadoService.getAllEmpleadoFechaId(id);
    }
}
