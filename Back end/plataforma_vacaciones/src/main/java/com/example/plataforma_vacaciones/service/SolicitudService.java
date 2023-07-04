package com.example.plataforma_vacaciones.service;
import com.example.plataforma_vacaciones.percistence.entities.SolicitudEntity;
import com.example.plataforma_vacaciones.percistence.model.SolicitudDTO;
import com.example.plataforma_vacaciones.percistence.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class SolicitudService {

    private static SolicitudRepository solicitudRepository;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    // Metodo para obtener todas las solicitudes enviadas
    public List<SolicitudEntity> getAllSolicitud() {
           try {
            return solicitudRepository.findAll();
        } catch (Exception e) {
            System.err.println("Error al intentar obtener todas las solicitudes:" + e);
            return null;
        }
    }

    // Metodo para crear una solicitud
    public SolicitudEntity crearSolicitud(SolicitudEntity solicitud){
          try {
                return solicitudRepository.save(solicitud);
        } catch (Exception e){
            System.err.println("Error al intentar crear solicitud:"+e);
            return null;
        }
    }

    // Metodo para actualizar la solicitud
    public SolicitudEntity updateSolicitud(SolicitudEntity solicitud, Long id){
        try {
            return solicitudRepository.findById(id).map(
                    solicitudUpd -> {
                        solicitudUpd.setEmpleado(solicitud.getEmpleado());
                        solicitudUpd.setFechafin(solicitud.getFechafin());
                        solicitudUpd.setFechainicio(solicitud.getFechainicio());
                        solicitudUpd.setFechasolicitud(solicitud.getFechasolicitud());
                        solicitudUpd.setNotasolicitud(solicitud.getNotasolicitud());
                        solicitudUpd.setEstadosadministrador(solicitud.getEstadosadministrador());
                        solicitudUpd.setEstadossupervisor(solicitud.getEstadossupervisor());
                        return solicitudRepository.save(solicitudUpd);

                    }
            ).get();
        }
        catch (Exception e){
            System.err.println("Error al intentar actualizar solicitud:"+e);
            return null;
        }
    }

    // Metodo para eliminar la solicitud
    public void deleteSolicitud(SolicitudEntity solicitud){
        try {
            solicitudRepository.delete(solicitud);
        }    catch (Exception e){
            System.err.println("Error al intentar eliminar solicitud:"+e);
        }
    }

    // Metodo para obtener todas las solicitudes por las fechas mas recientes
    public List<SolicitudEntity> SolicitudFecha() {
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "fechasolicitud");
            return solicitudRepository.findAll(sort);
        } catch (Exception e) {
            System.err.println("Error al intentar obtener todas las solicitudes por las fechas: " + e);
            return null;
        }
    }

    // Metodo para obtener todas las solicitudes por las fechas mas recientes con el id de un empleado
    public static List<SolicitudDTO> getAllSolicitudFechaId(Long idEmpleado) {
        try  {
            return solicitudRepository.listarsolicitudesFechaDesc(idEmpleado).stream().map(solicitud -> {
                return new SolicitudDTO((Integer)solicitud[0],(BigInteger)solicitud[1],
                        (String)  solicitud[2], (String) solicitud[3], LocalDate.parse(solicitud[4].toString()),(int)solicitud[5]);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error al intentar obtener todas las solicitudes del empleado: "  +idEmpleado+ e);
            return null;
        }
    }

    // Método para validar las si cumplecon los requisitos para las vacaciones
    public static boolean validateVacation(SolicitudEntity solicitud){

            LocalDateTime fechaActual = LocalDate.now().atStartOfDay();
            long mesesTrabajados = ChronoUnit.MONTHS.between(solicitud.getFechainicio(), fechaActual);
            long diasAntisipadosSolicitud = ChronoUnit.DAYS.between(solicitud.getFechasolicitud(), fechaActual);
            long diasSolicitados = ChronoUnit.DAYS.between(solicitud.getFechainicio(), solicitud.getFechafin());
            Long diashabiles = mesesTrabajados * (15 / 12) ;
            int  diasVacacionesconsumidas = diasVacacionedisfrutadas(getAllSolicitudFechaId(solicitud.getEmpleado().getId_empleado()));

            // between(menor , mqayor)
            if (diasSolicitados <= 0 ) {
                System.out.println("Cantidad inválida de días de vacaciones.");
                return false;
            }
            // validar 15 dias antes de la fecha de inicio de las vacaciones
            if (diasAntisipadosSolicitud < 15) {
                System.out.println("No cumple 15 días de anticipación de la solicitud");
                return false;
            }
            // Validar contrato vigente
            if (!solicitud.getEmpleado().getUsuario().getContrato().equals("vigente")) {
                System.out.println("Contrato no vigente");
                return false;
            }
            // Validar periodo de prueba
            if (mesesTrabajados <= 2)  {
                System.out.println("No se cumple con el periodo de prueba que es de minimo dos meses");
                return false;
            }
        if ((diashabiles - diasVacacionesconsumidas ) >= solicitud.getDiassolicitados()) {
            System.out.println("No se cumple con los dias permitidos");
            return false;
        }
            if (solicitud.getDiassolicitados()<=6) {
                System.out.println("No se cumple con los dias permitidos");
                return false;

            }
            return true;

    }

    private static int diasVacacionedisfrutadas(List<SolicitudDTO> diasConsumidos){
        AtomicInteger contador = new AtomicInteger();
        diasConsumidos.forEach(solicitud -> {
            if(!solicitud.getEstadosadministrador().equals("rechazada") || !solicitud.getEstadossupervisor().equals("pendiente")){
                contador.addAndGet(solicitud.getDiassolicitados());
            }
        });
                return Integer.parseInt(String.valueOf(diasConsumidos));

    }


    // Metodo para crear una solicitud
    public SolicitudEntity crearSolicitudConValidacion(SolicitudEntity solicitud){
        try {
            if (validateVacation(solicitud) == true) {
                return solicitudRepository.save(solicitud);
            }
        } catch (Exception e){
            System.err.println("Error al intentar crear solicitud con las validaciones:"+e);
            return null;
        }
        System.err.println("Error al intentar crear solicitud con las validaciones:");
        return null;
    }


}
