package io.github.nfdeveloper.rh_software.respositories;

import io.github.nfdeveloper.rh_software.entities.enums.Status;
import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.rh_software.entities.models.Funcao;

import java.util.List;
import java.util.Optional;

public interface FuncaoRepository extends JpaRepository<Funcao, Long>{

    Optional<Funcao> findByIdAndGrupo(Long id, Grupo grupo);

    List<Funcao> findByGrupo(Grupo grupo);

    List<Funcao> findByGrupoAndStatus(Grupo grupo, Status status);
}
