package br.com.zup.DestinoZup.destino.dto;

import br.com.zup.DestinoZup.categoria.Categoria;
import br.com.zup.DestinoZup.regiao.Regiao;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DestinoEntradaDTO {
    @Size(min = 4, max = 100, message = "{validacao.nome.size}")
    @NotNull(message = "{validacao.nome.not-null}")
    private String nome;
    @Valid
    private Regiao regiao;
    @Valid
    private List<Categoria> categorias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
