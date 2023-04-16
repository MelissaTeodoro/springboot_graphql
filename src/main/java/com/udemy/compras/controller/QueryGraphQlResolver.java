package com.udemy.compras.controller;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.entity.Cliente;
import com.udemy.compras.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQlResolver implements GraphQLQueryResolver {

    @Autowired
    private ClienteRepository clienteRepository;

    public String hello() {
        return "Hello GraphQl";
    }

    public int soma(int a, int b) {
        return a + b;
    }

    public Cliente cliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> clientes() {
        return clienteRepository.findAll();
    }

}
