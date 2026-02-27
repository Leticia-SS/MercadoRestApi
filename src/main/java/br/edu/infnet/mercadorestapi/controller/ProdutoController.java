package br.edu.infnet.mercadorestapi.controller;

import br.edu.infnet.mercadorestapi.model.Produto;
import br.edu.infnet.mercadorestapi.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public String incluirProduto(@RequestBody Produto produto) {
        produtoService.addProduto(produto);
        return "Produto Enviado";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Integer id) {
        Produto produto = produtoService.findById(id);
        if(produto == null) {
            return new ResponseEntity<>("ERROR: Produto não encontrado",HttpStatus.NOT_FOUND);
        }
        produtoService.deleteProduto(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

}
