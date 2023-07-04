package com.example.plataforma_vacaciones.percistence.repository;
import com.example.plataforma_vacaciones.percistence.entities.SolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<SolicitudEntity, Long> {
/*
    busqueda en la base de datos  con sql para traer todas las solicitudes de un usuario, donde estan ordenadas
    SELECT   s.id_empleado , e.id_documento , s.id_estado_supervisor, s.id_estado_administrador,s.fecha_control_estado FROM solicitud as s
    INNER JOIN empleado as e
    on e.id_empleado= s.id_empleado
    WHERE e.id_documento =66
    ORDER BY fecha_solicitud DESC;
*/
    @Query(value = "SELECT   s.id_empleado , e.id_documento , s.estado_supervisor, s.estado_administrador,s.fecha_control_estado, s.diassolicitados FROM solicitud as s INNER JOIN  empleado as e on e.id_empleado= s.id_empleado  WHERE e.id_documento =:id ORDER BY fecha_solicitud DESC;", nativeQuery=true)
    List<Object[]> listarsolicitudesFechaDesc(Long id);
}
