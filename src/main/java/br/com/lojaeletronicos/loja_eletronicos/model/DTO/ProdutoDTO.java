package br.com.lojaeletronicos.loja_eletronicos.model.DTO;

import br.com.lojaeletronicos.loja_eletronicos.model.entity.Produto;

import java.math.BigDecimal;
import java.sql.Date;


public class ProdutoDTO {

    private Integer id;
    private String codigoProduto;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Date dataEntrada;
    private Integer quantidade;

    public ProdutoDTO(Integer id, String codigoProduto, String nome, String descricao, BigDecimal preco, Date dataEntrada, Integer quantidade) {
        this.id = id;
        this.codigoProduto = codigoProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataEntrada = dataEntrada;
        this.quantidade = quantidade;
    }

    public ProdutoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
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

    static ProdutoDTO converteProdutoParaDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getCodigoProduto(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getDataEntrada(),
                produto.getQuantidade()
        );
    }
}
