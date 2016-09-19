package br.com.phac.xfood.service;


import java.util.ArrayList;
import java.util.List;

import br.com.phac.xfood.domain.Produto;

public class ProdutosService {

    public static List<Produto> getProdutos(String tipo){
        List<Produto> produtos = new ArrayList<Produto>();


        for(int i = 0; i < 20; i ++){
            Produto prod = new Produto();

            prod.setId(i);
            prod.setNomeProduto(tipo + i);
            prod.setValorProduto(i);
            prod.setImagemProduto("teste");
            prod.setDescricaoProduto("Aqui fica a descrição do produto");

            produtos.add(prod);
        }

        return produtos;
    }

}
