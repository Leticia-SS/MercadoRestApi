package br.edu.infnet.mercadorestapi.service;

import br.edu.infnet.mercadorestapi.model.Produto;
import br.edu.infnet.mercadorestapi.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
