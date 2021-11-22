package br.com.zup.DestinoZup.categoria;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
