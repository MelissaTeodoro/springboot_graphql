package com.udemy.compras.controller.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQlResolver implements GraphQLQueryResolver {

    public String hello() {
        return "Hello GraphQl";
    }

    public int soma(int a, int b) {
        return a + b;
    }

}
