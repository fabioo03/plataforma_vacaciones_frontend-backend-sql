package com.example.plataforma_vacaciones.service;
import com.example.plataforma_vacaciones.percistence.entities.EmpleadoEntity;
import com.example.plataforma_vacaciones.percistence.model.EmpleadoDTO;
import com.example.plataforma_vacaciones.percistence.model.SolicitudDTO;
import com.example.plataforma_vacaciones.percistence.repository.EmpleadoRepository;
import com.example.plataforma_vacaciones.percistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {
    private static EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    // nos traemos todos los empleados que estan creados en la base de datos
    public List<EmpleadoEntity> getAllEmpleados(){
        try {
           //   empleadoRepository.findByUsuario(9L);
            return empleadoRepository.findAll();
        }    catch (Exception e){
            System.err.println("Error al intentar obtener todos los empleados:"+e);
            return null;
        }
    }

    // creamos un nuevo empleado y lo guardamos en la base de datos se le debe de enviar toda la informacion de
    // usuario, equipo y administrador con sus respectivos datos
    public EmpleadoEntity crearEmpleado(EmpleadoEntity empleado) {
        try {
            return empleadoRepository.save(empleado);
        } catch (Exception e) {
            System.err.println("Error al intentar crear empleado:" + e);
            return null;
        }
    }

    // actualizamos un empleado y lo guardamos en la base de datos se le debe de enviar toda la informacion de
    // usuario, equipo y administrador con sus respectivos datos ya actualizados
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleado, Long id){
        try {
            return  empleadoRepository.findById(id).map(
                    empleadoUPD -> {

                        empleadoUPD.setId_empleado(empleado.getId_empleado());
                        empleadoUPD.setUsuario(empleado.getUsuario());
                        empleadoUPD.setEquipo(empleado.getEquipo());
                        empleadoUPD.setAdministrador(empleado.getAdministrador());

                        return empleadoRepository.save(empleadoUPD);
                    }
            ).get();
        }
        catch (Exception e){
            System.err.println("Error al intentar actualizar empleado:" + e);
            return null;
        }

    }

    // eliminamos un empleado de la base de datos se debe de tener encuesta si va a eliminar tambien lo del equipo y administrador
    // ya que puede que esta informacion lo pueda tener otro usuario y no se lo permitira eliminar.
    public void deleteEmpleado(EmpleadoEntity empleado){
        try {
            empleadoRepository.delete(empleado);
        }
        catch (Exception e){
            System.err.println("Error al intentar eliminar empleado:" + e);
        }

    }

    // Metodo para obtenermpleado
    public static List<EmpleadoDTO> getAllEmpleadoFechaId(Long idEmpleado) {
    //    try  {
            return empleadoRepository.listarEmpleados(idEmpleado).stream().map(empleado -> {
                return new EmpleadoDTO(
                        (Integer)empleado[0], (BigInteger)empleado[1], (String)  empleado[2], (String) empleado[3],
                        (String) empleado[4], (String) empleado[5], (String) empleado[6], (String) empleado[7], (String) empleado[8],
                        (String) empleado[7], (String) empleado[8], (String) empleado[9], (String) empleado[10]);
            }).collect(Collectors.toList());
      /*  } catch (Exception e) {
            System.err.println("Error al intentar obtener todos los empleado: "  +idEmpleado+ e);
            return null;
        }*/
    }



}
