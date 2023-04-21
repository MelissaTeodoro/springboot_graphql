package com.udemy.compras.controller.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.controller.graphql.service.ProdutoService;
import com.udemy.compras.entity.Produto;
import com.udemy.compras.entity.ProdutoInput;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService produtoService;

    public Produto produto(Long id) {
        return produtoService.findById(id);
    }

    public List<Produto> produtos() {
        return produtoService.findAll();
    }

    public Produto saveProduto(ProdutoInput input) {
        final ModelMapper modelMapper = new ModelMapper();
        final Produto produto = modelMapper.map(input, Produto.class);

        return produtoService.save(produto);
    }

    public Boolean deleteProduto(Long id) {
        return produtoService.deleteById(id);
    }

}
