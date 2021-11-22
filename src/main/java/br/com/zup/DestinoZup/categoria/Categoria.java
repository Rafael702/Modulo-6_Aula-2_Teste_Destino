package br.com.zup.DestinoZup.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @Size(min = 4, max = 100, message = "{validacao.nome.size}")
    @NotNull(message = "{validacao.nome.not-null}")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
