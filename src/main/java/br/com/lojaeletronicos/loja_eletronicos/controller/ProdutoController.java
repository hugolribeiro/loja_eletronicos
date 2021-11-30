package br.com.lojaeletronicos.loja_eletronicos.controller;

import br.com.lojaeletronicos.loja_eletronicos.dao.ProdutoDAO;
import br.com.lojaeletronicos.loja_eletronicos.factory.ConnectionFactory;
import br.com.lojaeletronicos.loja_eletronicos.model.DTO.ProdutoDTO;
import br.com.lojaeletronicos.loja_eletronicos.model.form.ProdutoForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    @GetMapping("/{codigoProduto}")
    public ResponseEntity<ProdutoDTO> getProdutoByCodigoProduto(@RequestParam String codigoProduto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return null;
    }

    @PostMapping()
    public ResponseEntity<?> saveProduto(@RequestBody ProdutoForm produtoForm) throws SQLException, ParseException {
        Connection connection = ConnectionFactory.getConexao();
        ProdutoDAO produtoDAO = new ProdutoDAO(connection);
        boolean successfull = produtoDAO.salvar(produtoForm);
        if (successfull) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping()
    public ResponseEntity<?> updateProduto(@RequestParam String codigoProduto, @RequestBody ProdutoForm produtoForm) throws ParseException, SQLException {
        Connection connection = ConnectionFactory.getConexao();
        ProdutoDAO produtoDAO = new ProdutoDAO(connection);
        return new ResponseEntity<>(produtoDAO.atualiza(produtoForm, codigoProduto),HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteproduto(@RequestParam String codigoProduto) throws SQLException {
        Connection connection = ConnectionFactory.getConexao();
        ProdutoDAO produtoDAO = new ProdutoDAO(connection);
        return new ResponseEntity<>(produtoDAO.remover(codigoProduto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoDTO>> listaTodosProdutos() throws SQLException {
        Connection connection = ConnectionFactory.getConexao();
        ProdutoDAO produtoDAO = new ProdutoDAO(connection);
        return new ResponseEntity<>(produtoDAO.listar(), HttpStatus.OK);
    }
}
