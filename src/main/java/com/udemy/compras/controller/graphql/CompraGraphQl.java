package com.udemy.compras.controller.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.controller.graphql.service.ClienteService;
import com.udemy.compras.controller.graphql.service.CompraService;
import com.udemy.compras.controller.graphql.service.ProdutoService;
import com.udemy.compras.entity.Compra;
import com.udemy.compras.entity.CompraInput;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class CompraGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Compra compra(Long id) {
        return compraService.findById(id);
    }

    public List<Compra> compras(int page, int size) {

        final PageRequest pageRequest = PageRequest.of(page, size);
        return compraService.findAll(pageRequest);
    }

    public Compra saveCompra(CompraInput input) {
        final ModelMapper modelMapper = new ModelMapper();
        final Compra compra = modelMapper.map(input, Compra.class);
        compra.setData(new Date());
        compra.setCliente(clienteService.findById(input.getClienteId()));
        compra.setProduto(produtoService.findById(input.getProdutoId()));

        return compraService.save(compra);
    }

    public Boolean deleteCompra(Long id) {
        return compraService.deleteById(id);
    }

}
