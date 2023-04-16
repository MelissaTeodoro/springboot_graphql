package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQl implements GraphQLQueryResolver {

    public String hello() {
        return "Hello GraphQl";
    }

    public int soma(int a, int b) {
        return a + b;
    }

}
