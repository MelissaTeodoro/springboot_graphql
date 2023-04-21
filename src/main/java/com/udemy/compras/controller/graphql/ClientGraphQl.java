package com.udemy.compras.controller.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.service.ClienteService;
import com.udemy.compras.entity.Cliente;
import com.udemy.compras.entity.input.ClienteInput;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente cliente(Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> clientes() {
        return clienteService.findAll();
    }

    public Cliente saveCliente(ClienteInput input) {
        final ModelMapper modelMapper = new ModelMapper();
        final Cliente cliente = modelMapper.map(input, Cliente.class);

        return clienteService.save(cliente);
    }

    public Boolean deleteCliente(Long id) {
        return clienteService.deleteById(id);
    }

}
