package io.github.nfdeveloper.rh_software.respositories;

import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.rh_software.entities.models.Setor;

import java.util.List;
import java.util.Optional;

public interface SetorRepository extends JpaRepository<Setor, Long>{

    Optional<Setor> findByIdAndGrupo(Long id, Grupo grupo);

    List<Setor> findByGrupo(Grupo grupo);
}
