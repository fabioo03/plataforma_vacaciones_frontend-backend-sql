package com.example.plataforma_vacaciones.percistence.repository;
import com.example.plataforma_vacaciones.percistence.entities.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Long> {
}
