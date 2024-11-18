package io.github.nfdeveloper.rh_software.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    @Column(name = "estado", length = 50)
    public String estado;

    @Column(name = "cidade", length = 80)
    public String cidade;

    @Column(name = "bairro", length = 80)
    public String bairro;

    @Column(name = "rua", length = 50)
    public String rua;

    @Column(name = "numero", length = 10)
    public String numero;

    @Column(name = "cep", length = 20)
    public String cep;

    @Column(name = "ponto_referencia", length = 200)
    public String pontoReferencia;
}
