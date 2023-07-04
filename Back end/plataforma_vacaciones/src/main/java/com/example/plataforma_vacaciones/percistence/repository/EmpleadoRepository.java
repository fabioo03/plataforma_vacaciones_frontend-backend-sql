package com.example.plataforma_vacaciones.percistence.repository;
import com.example.plataforma_vacaciones.percistence.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {

    @Query(value = "SELECT e.id_empleado, u.id_documento,u.tipo_documento, u.Primer_nombre,u.segundo_nombre,u.primer_apellido,u.segundo_apellido,u.correo,u.apodo_usuario,u.contraseña,eq.nombre_equipo FROM  usuario as u INNER JOIN empleado as e on e.id_documento= u.id_documento INNER JOIN  equipo as eq on e.id_equipo = eq.id_equipo INNER JOIN administrador as ad on e.id_administrador = ad.id_administrador  INNER JOIN  contrato as c on u.id_contrato = c.id_contrato INNER JOIN  domicilio as d on u.id_domicilio = d.id_domicilio WHERE e.id_documento = 1007268653;", nativeQuery = true)
    List<Object[]> listarEmpleados(Long id);
  //  EmpleadoEntity findByUsuario(Long usuario);


}
