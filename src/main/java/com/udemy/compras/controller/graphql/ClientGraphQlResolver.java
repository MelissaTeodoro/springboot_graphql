package com.udemy.compras.controller.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.controller.graphql.service.ClienteService;
import com.udemy.compras.entity.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientGraphQlResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente cliente(Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> clientes() {
        return clienteService.findAll();
    }

    public Cliente saveCliente(Long id, String nome, String email) {
        return clienteService.save(new Cliente(id, nome, email));
    }

    public Boolean deleteCliente(Long id) {
        return clienteService.deleteById(id);
    }

}
