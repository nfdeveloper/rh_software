package io.github.nfdeveloper.rh_software.respositories;

import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.rh_software.entities.models.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

    Optional<Funcionario> findByIdAndGrupo(Long id, Grupo grupo);

    List<Funcionario> findByGrupo(Grupo grupo);
}
