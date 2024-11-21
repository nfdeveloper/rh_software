package io.github.nfdeveloper.rh_software.respositories;

import io.github.nfdeveloper.rh_software.entities.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.rh_software.entities.models.Marcacao;

import java.util.List;
import java.util.Optional;

public interface MarcacaoRepository extends JpaRepository<Marcacao, Long>{

    Optional<Marcacao> findByIdAndFuncionario(Long id, Funcionario funcionario);

    List<Marcacao> findByFuncionario(Funcionario funcionario);
}
