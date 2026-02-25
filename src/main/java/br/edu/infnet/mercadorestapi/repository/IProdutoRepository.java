package br.edu.infnet.mercadorestapi.repository;

import br.edu.infnet.mercadorestapi.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IProdutoRepository extends CrudRepository<Produto, Integer> {

}
