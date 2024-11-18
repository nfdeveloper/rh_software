package io.github.nfdeveloper.rh_software.entities.models;

import java.io.Serializable;

import io.github.nfdeveloper.rh_software.entities.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fnc")
public class Funcao implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "nome", length = 80)
    private String nome;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "hr_semana")
    private Double horasSemana;

    @Column(name = "hr_dia")
    private Double horasDia;

    @Column(name = "hr_intervalo")
    private Double horasIntervalo;

    private Status status;

    @ManyToOne
	@JoinColumn(name = "grupo_id")
    private Grupo grupo;

}
