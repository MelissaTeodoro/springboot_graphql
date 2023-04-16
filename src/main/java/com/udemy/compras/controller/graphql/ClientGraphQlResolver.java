package com.udemy.compras.controller.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.entity.Cliente;
import com.udemy.compras.repository.ClienteRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientGraphQlResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> clientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente saveCliente(Long id, String nome, String email) {
        return clienteRepository.save(new Cliente(id, nome, email));
    }

    @Transactional
    public Boolean deleteCliente(Long id) {
        if (clienteRepository.findById(id).isPresent()) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
