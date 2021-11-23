package br.com.lojaeletronicos.loja_eletronicos.model.form;

import java.math.BigDecimal;
import java.sql.Date;


public class ProdutoForm {

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Date dataEntrada;
    private Integer quantidade;

    public ProdutoForm(String nome, String descricao, BigDecimal preco, Date dataEntrada, Integer quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataEntrada = dataEntrada;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
