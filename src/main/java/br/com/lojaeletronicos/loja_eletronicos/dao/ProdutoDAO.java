package br.com.lojaeletronicos.loja_eletronicos.dao;

import br.com.lojaeletronicos.loja_eletronicos.model.DTO.ProdutoDTO;
import br.com.lojaeletronicos.loja_eletronicos.model.form.ProdutoForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ProdutoDAO {

    public ProdutoDAO() {
    }

    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public boolean salvar(ProdutoForm produto) {
        String codigoProduto = UUID.randomUUID().toString();
        try (PreparedStatement pstm = conexao.prepareStatement(
                "INSERT INTO produto (codigo_produto, nome, descricao, preco, data_entrada, quantidade)" +
                        " VALUES (?, ?, ?, ?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, codigoProduto);
            pstm.setString(2, produto.getNome());
            pstm.setString(3, produto.getDescricao());
            pstm.setBigDecimal(4, produto.getPreco());
            pstm.setDate(5, produto.getDataEntrada());
            pstm.setInt(2, produto.getQuantidade());

            pstm.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ProdutoDTO> listar() {
        List<ProdutoDTO> produtos = new ArrayList<>();

        try (PreparedStatement pstm = conexao.prepareStatement(
                "SELECT id,codigo_produto, nome, descricao, preco, data_entrada, quantidade FROM PRODUTO;")) {

            pstm.execute();

            try (ResultSet rts = pstm.getResultSet()) {

                while (rts.next()) {
                    ProdutoDTO produto = new ProdutoDTO();

                    produto.setId(rts.getInt("ID"));
                    produto.setCodigoProduto(rts.getString("CODIGO_PRODUTO"));
                    produto.setNome(rts.getString("NOME"));
                    produto.setDescricao(rts.getString("DESCRICAO"));
                    produto.setPreco(rts.getBigDecimal("PRECO"));
                    produto.setDataEntrada(rts.getDate("DATA_ENTRADA"));
                    produto.setQuantidade(rts.getInt("QUANTIDADE"));

                    produtos.add(produto);
                }

                return produtos;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro!");
        }
    }

    public boolean remover(String codigoProduto) throws SQLException {

        try (PreparedStatement pstm = conexao.prepareStatement(
                "DELETE FROM PRODUTO WHERE ID > ?")) {

            pstm.setString(1, codigoProduto);

            pstm.execute();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro!");
        }
    }

    public boolean atualiza(ProdutoForm produto, String codigoProduto) {

        //UPDATE NOME_TABELA SET NOME = ''',  DESCRICAO =''',
        //PRECO = 0, DATA_ENTRADA = TO_DATE(""), QUANTIDADE = 0
        //WHERE CODIGO_PRODUTO = '';

        try (PreparedStatement pstm = conexao.prepareStatement(
                "UPDATE NOME_TABELA SET NOME = ?," +
                        "DESCRICAO = ?, PRECO = ?, DATA_ENTRADA = ?, QUANTIDADE = ?" +
                        "WHERE CODIGO_PRODUTO = ?")) {

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setBigDecimal(3, produto.getPreco());
            pstm.setDate(4, produto.getDataEntrada());
            pstm.setInt(5, produto.getQuantidade());
            pstm.setString(6, codigoProduto);

            pstm.execute();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro!");
        }
    }
}
