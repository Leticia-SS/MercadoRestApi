package br.edu.infnet.mercadorestapi.controller;

import br.edu.infnet.mercadorestapi.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    List<Produto> produtos;

    public ProdutoController() {
        produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Produto", 1, 19));
        produtos.add(new Produto(2, "Produto 2", 8, 20));
        produtos.add(new Produto(3, "Produto 3", 9, 63));
        produtos.add(new Produto(4, "Produto 4", 2, 95));
        produtos.add(new Produto(5, "Produto 5", 8, 65));
        produtos.add(new Produto(6, "Produto 6", 6, 15));
        produtos.add(new Produto(7, "Produto 7", 5, 22));
        produtos.add(new Produto(8, "Produto 8", 10, 71));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> consultarProdutos() {
        return ResponseEntity.ok(produtos);
    }
}
