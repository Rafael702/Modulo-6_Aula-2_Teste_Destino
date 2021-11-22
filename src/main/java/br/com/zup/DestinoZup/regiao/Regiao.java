package br.com.zup.DestinoZup.regiao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regioes")
public class Regiao {
    @Id
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
