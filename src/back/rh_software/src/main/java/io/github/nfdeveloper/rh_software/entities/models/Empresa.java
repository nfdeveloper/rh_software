package io.github.nfdeveloper.rh_software.entities.models;

import java.io.Serializable;

import io.github.nfdeveloper.rh_software.entities.enums.PorteEmpresa;
import io.github.nfdeveloper.rh_software.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp")
public class Empresa implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "cnpj", length = 120, unique = true)
    private String cnpj;

    @Column(name = "razao_social", length = 120)
    private String razaoSocial;

    @Column(name = "fantasia", length = 120)
    private String fantasia;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @Column(name = "porte")
    private PorteEmpresa porte;

    @Column(name = "qtd_func")
    private Long quantidadeFuncionarios;

    private Status status;

    @ManyToOne
	@JoinColumn(name = "grupo_id")
    private Grupo grupo;

}
