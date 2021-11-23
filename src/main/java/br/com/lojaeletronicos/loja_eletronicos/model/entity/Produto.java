package br.com.lojaeletronicos.loja_eletronicos.model.entity;

import java.math.BigDecimal;
import java.sql.Date;


public class Produto {

    private Integer id;
    private String codigoProduto;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Date dataEntrada;
    private Integer quantidade;

    public Produto() {}

    public Produto(String nome, String descricao, BigDecimal preco, Date dataEntrada, Integer quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataEntrada = dataEntrada;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto\nid: " + id +"\nnome: " + nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Integer getId() {
        return id;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

}
