package io.github.nfdeveloper.rh_software.web.dtos.funcionario;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.nfdeveloper.rh_software.config.CustomLocalDateTimeDeserializer;
import io.github.nfdeveloper.rh_software.entities.enums.Status;
import io.github.nfdeveloper.rh_software.entities.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioCreateDTO {

    private Long id;
    private String nomeCompleto;
    private String sobrenome;
    private String cpf;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dataNascimento;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dataAdmissao;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dataDesligamento;
    private Double peso;
    private Double altura;
    private Double imc;
    private String imcDescricao;
    private Boolean pdc;
    private Boolean possuiFilhos;
    private Endereco endereco;
    private Contato contato;
    private Status status;
    private Empresa empresa;
    private Setor setor;
    private Funcao funcao;
}
