package com.example.plataforma_vacaciones.service;
import com.example.plataforma_vacaciones.percistence.entities.AdministradorEntity;
import com.example.plataforma_vacaciones.percistence.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AdministradorService {
    private AdministradorRepository  administradorRepository;

    @Autowired
    public AdministradorService (AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    // buscamos todos los administradores de la base de datos
    public List<AdministradorEntity> getAllAdministrador(){
        try {
            return administradorRepository.findAll();
        } catch (Exception e) {
            System.err.println("Error al intentar buscar todos los administradores de la base de datos :" + e);
            return null;
        }

    }

    // creamos un administrador y lo guardamos en la base de datos
    public AdministradorEntity crearAdministrador(AdministradorEntity administrador){
        try {
            return administradorRepository.save(administrador);
        }    catch (Exception e) {
            System.err.println("Error al intentar crear administrador:" + e);
            return null;
        }
    }

    // actualizamos un administrador y lo guardamos en la base de datos un administrador
    public AdministradorEntity updateAdministrador(AdministradorEntity administrador, Long id){
        try {
            return   administradorRepository.findById(id).map(
                    administradorUpd -> {
                        administradorUpd.setAdministradorid(administrador.getAdministradorid());
                        administradorUpd.setUsuario(administrador.getUsuario());
                        return administradorRepository.save(administradorUpd);
                    }
            ).get();
        }
        catch (Exception e){
            System.err.println("Error al intentar actualizar administrador:" + e);
            return null;
        }

    }

    // eliminamos un administrador de la base de datos
    public void deleteAdministrador(AdministradorEntity administrador){
        try {
            administradorRepository.delete(administrador);
        }
        catch (Exception e){
            System.err.println("Error al intentar eliminar administrador:" + e);
        }


    }

}
