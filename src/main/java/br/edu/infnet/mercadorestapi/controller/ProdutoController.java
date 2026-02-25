package br.edu.infnet.mercadorestapi.controller;

import br.edu.infnet.mercadorestapi.model.Produto;
import br.edu.infnet.mercadorestapi.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService1) {
        this.produtoService = produtoService1;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> consultarProdutos() {
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> consultarProduto(@PathVariable Integer id) {
        Produto produto = produtoService.findById(id);
        if (produto==null) {
            return new ResponseEntity<>("ERROR: Produto não encontrado",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(produto);
    }

}
