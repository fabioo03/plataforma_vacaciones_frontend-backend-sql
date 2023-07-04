package com.example.plataforma_vacaciones.percistence.repository;
import com.example.plataforma_vacaciones.percistence.entities.EquipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<EquipoEntity, Long> {
}
