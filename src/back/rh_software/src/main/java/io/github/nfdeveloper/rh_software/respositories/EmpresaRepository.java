package io.github.nfdeveloper.rh_software.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.rh_software.entities.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
