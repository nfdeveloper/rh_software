package io.github.nfdeveloper.rh_software.entities.models;

import java.io.Serializable;
import java.io.ObjectInputFilter.Status;
import java.time.LocalDateTime;

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
@Table(name = "func")
public class Funcionario implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

     @Column(name = "nome_completo", length = 200)
    private String nomeCompleto;

    @Column(name = "sobrenome", length = 80)
    private String sobrenome;

    @Column(name = "cpf", length = 20, unique = true)
    private String cpf;

    @Column(name = "dt_nascimento")
    private LocalDateTime dataNascimento;

    @Column(name = "dt_admissao")
    private LocalDateTime dataAdmissao;

    @Column(name = "dt_desligamento")
    private LocalDateTime dataDesligamento;

    private Double peso;

    private Double altura;

    private Double imc;

    @Column(name = "imc_desc", length = 80)
    private String imcDescricao;

    private Boolean pdc;

    @Column(name = "possui_filhos")
    private Boolean possuiFilhos;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    private Status status;

    @ManyToOne
	@JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
	@JoinColumn(name = "setor_id")
    private Setor setor;

    @ManyToOne
	@JoinColumn(name = "funcao_id")
    private Funcao funcao;

}
