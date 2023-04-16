package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQlResolver implements GraphQLQueryResolver {

    public String hello() {
        return "Hello GraphQl";
    }

    public int soma(int a, int b) {
        return a + b;
    }

    public Cliente cliente() {
        return new Cliente("Mel", "mel@test.com");
    }

    public List<Cliente> clientes() {
        final List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            clientes.add(new Cliente("Cliente " + i, "mail" + i + "test.com"));
        }
        return clientes;
    }

}
