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
    public String nome;

    @Column(name = "descricao", length = 500)
    public String descricao;

    @Column(name = "hr_semana")
    public Double horasSemana;

    @Column(name = "hr_dia")
    public Double horasDia;

    @Column(name = "hr_intervalo")
    public Double horasIntervalo;

    public Status status;

    @ManyToOne
	@JoinColumn(name = "grupo_id")
    public Grupo grupo;

}