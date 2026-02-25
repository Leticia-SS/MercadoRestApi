package br.edu.infnet.mercadorestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private double preco;

}
