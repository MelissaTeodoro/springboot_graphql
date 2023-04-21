package com.udemy.compras.controller.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.controller.graphql.service.CompraService;
import com.udemy.compras.entity.Cliente;
import com.udemy.compras.entity.Compra;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private CompraService compraService;

    public List<Compra> compras(Cliente cliente) {
        return compraService.findAllByCliente(cliente);
    }
}
