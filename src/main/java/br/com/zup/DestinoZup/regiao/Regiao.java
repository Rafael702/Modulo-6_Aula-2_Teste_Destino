package br.com.zup.DestinoZup.regiao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "regioes")
public class Regiao {
    @Id
    @Size(min = 4, max = 100, message = "{validacao.nome.size}")
    @NotNull(message = "{validacao.nome.not-null}")
    private String nome;

    public Regiao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
