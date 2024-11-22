package io.github.nfdeveloper.rh_software.web.dtos.marcacao;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.nfdeveloper.rh_software.config.CustomLocalDateTimeDeserializer;
import io.github.nfdeveloper.rh_software.entities.enums.StatusMarcacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarcacaoCreateDTO {

    private Long id;
    private String localizacao;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dataMarcacao = LocalDateTime.now();
    private StatusMarcacao status = StatusMarcacao.EM_ANALISE;
    private Long funcionarioId;
}
