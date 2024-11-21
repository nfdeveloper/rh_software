package io.github.nfdeveloper.rh_software.respositories;

import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.rh_software.entities.models.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

    Optional<Empresa> findByIdAndGrupo(Long id, Grupo grupo);
    List<Empresa> findByGrupo(Grupo grupo);
 }
