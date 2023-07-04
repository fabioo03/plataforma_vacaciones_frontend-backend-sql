package com.example.plataforma_vacaciones.service;
import com.example.plataforma_vacaciones.percistence.entities.UsuarioEntity;
import com.example.plataforma_vacaciones.percistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // getAllUsuarios nos traemos todos los usuarios de la base de datos
    public List<UsuarioEntity> getAllUsuarios(){
        try {
            return usuarioRepository.findAll();
        }    catch (Exception e){
            System.err.println("Error al intentar obtener todos los usuarios:"+e);
            return null;
        }

    }

    // creamos un nuevo usuario y lo guardamos en la base de datos
    public UsuarioEntity crearUsuario(UsuarioEntity usuario){
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e){
            System.err.println("Error al intentar crear usuario:"+e);
            return null;
        }
    }
    // actualizamos un usuario y lo guardamos en la base de datos
    public UsuarioEntity updateUsuario(UsuarioEntity usuario, Long id){
        try {
            return usuarioRepository.findById(id).map(
                    usuarioUpd -> {
                        usuarioUpd.setTipodocumento(usuario.getTipodocumento());
                        usuarioUpd.setPrimernombre(usuario.getPrimernombre());
                        usuarioUpd.setSegundonombre(usuario.getSegundonombre());
                        usuarioUpd.setPrimerapellido(usuario.getPrimerapellido());
                        usuarioUpd.setSegundoapellido(usuario.getSegundoapellido());
                        usuarioUpd.setTelefono(usuario.getTelefono());
                        usuarioUpd.setCorreo(usuario.getCorreo());
                        usuarioUpd.setApodousuario(usuario.getApodousuario());
                        usuarioUpd.setContrasena(usuario.getContrasena());
                        usuarioUpd.setDomicilio(usuario.getDomicilio());
                        usuarioUpd.setContrato(usuario.getContrato());
                        return usuarioRepository.save(usuarioUpd);
                    }
            ).get();
        }    catch (Exception e){
            System.err.println("Error al intentar actualizar usuario:"+e);
            return null;
        }
    }
    // eliminamos un usuario de la base de datos
    public void deleteUsuario(UsuarioEntity usuario){
        try {
            usuarioRepository.delete(usuario);
        } catch (Exception e){
            System.err.println("Error al intentar eliminar usuario:"+e);
        }
    }

}
