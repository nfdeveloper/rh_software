package io.github.nfdeveloper.rh_software.entities.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.github.nfdeveloper.rh_software.entities.enums.StatusMarcacao;
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
@Table(name = "marc")
public class Marcacao implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "localizacao", length = 500)
    private String localizacao;

    @Column(name = "data_marcacao")
    private LocalDateTime dataMarcacao;
    
    private StatusMarcacao status;
    
    @ManyToOne
	@JoinColumn(name = "funcionario_id")
    public Funcionario funcionario;
}
