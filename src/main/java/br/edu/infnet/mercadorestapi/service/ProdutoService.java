package br.edu.infnet.mercadorestapi.service;

import br.edu.infnet.mercadorestapi.model.Produto;
import br.edu.infnet.mercadorestapi.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final IProdutoRepository produtoRepository;

    //@Autowired = descontinuado
    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll() {
        return (List<Produto>) produtoRepository.findAll();
    }

    public Produto findById(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
//        if (produto.isPresent()) {
//            return produto.get();
//        }
//        return null;
        return produto.orElse(null); //if simplificado
    }

    public void addProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public void deleteProduto(Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.deleteById(id);
        }
    }

}
