package io.github.nfdeveloper.rh_software.respositories;

import io.github.nfdeveloper.rh_software.entities.models.Empresa;
import io.github.nfdeveloper.rh_software.entities.models.Funcionario;
import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

    Optional<Funcionario> findByIdAndEmpresa(Long id, Empresa empresa);

    @Query("select f from Funcionario f where f.empresa.grupo = :grupo")
    List<Funcionario> findByGrupo(Grupo grupo);
}
