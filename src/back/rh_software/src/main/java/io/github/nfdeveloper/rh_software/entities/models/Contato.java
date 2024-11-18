package io.github.nfdeveloper.rh_software.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Contato {

    @Column(name = "telefone1", length = 50)
    public String telefone1;

    @Column(name = "telefone2", length = 50)
    public String telefone2;

    @Column(name = "telefone3", length = 50)
    public String telefone3;

    @Column(name = "telefone4", length = 50)
    public String telefone4;

    @Column(name = "celular1", length = 50)
    public String celular1;

    @Column(name = "celular2", length = 50)
    public String celular2;

    @Column(name = "celular3", length = 50)
    public String celular3;

    @Column(name = "celular4", length = 50)
    public String celular4;

    @Column(name = "email1", length = 50)
    public String email1;

    @Column(name = "email2", length = 50)
    public String email2;

    @Column(name = "email3", length = 50)
    public String email3;

    @Column(name = "email4", length = 50)
    public String email4;
}
