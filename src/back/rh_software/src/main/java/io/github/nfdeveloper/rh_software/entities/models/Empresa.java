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
@Table(name = "emp")
public class Empresa implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "cnpj", length = 120, unique = true)
    public String cnpj;

    @Column(name = "razao_social", length = 120)
    public String razaoSocial;

    @Column(name = "fantasia", length = 120)
    public String fantasia;

    public Endereco endereco;
    public Contato contato;

    @Column(name = "porte", length = 20)
    public String porte;

    public Status status;

    @ManyToOne
	@JoinColumn(name = "grupo_id")
    public Grupo grupo;

}
