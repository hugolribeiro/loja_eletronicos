package br.com.lojaeletronicos.loja_eletronicos.controller;

import br.com.lojaeletronicos.loja_eletronicos.dao.ProdutoDAO;
import br.com.lojaeletronicos.loja_eletronicos.model.DTO.ProdutoDTO;
import br.com.lojaeletronicos.loja_eletronicos.model.form.ProdutoForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    @GetMapping()
    public ResponseEntity<ProdutoDTO> getProdutoByCodigoProduto(@RequestParam String codigoProduto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return null;
    }

    @PostMapping()
    public ResponseEntity<?> saveProduto(@RequestBody ProdutoForm produtoForm){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        boolean successfull = produtoDAO.salvar(produtoForm);
        if (successfull) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping()
    public ResponseEntity<?> updateProduto(@RequestParam String codigoProduto, @RequestBody ProdutoForm produtoForm){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return new ResponseEntity<>(produtoDAO.atualiza(produtoForm, codigoProduto),HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteproduto(@RequestParam String codigoProduto) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return new ResponseEntity<>(produtoDAO.remover(codigoProduto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoDTO>> listaTodosProdutos(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return new ResponseEntity<>(produtoDAO.listar(), HttpStatus.OK);
    }
}