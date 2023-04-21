
# springboot_graphql
Demo project for Spring Boot using GraphQl

## Start Project
- Run **docker-compose up** (to start mysql docker container with migrations)
- Run ComprasApplication

- To view console graphiql - open http://localhost:8080/graphiql
  ![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-graphiql.png)

- To view console playground - open http://localhost:8080/playground
  ![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-playground.png)

## GraphQl Documentation
https://graphql.org/learn/

### Query
- Used to find data
  ![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-query.png)

### Mutations
- Used to insert, update or delete data
  ![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-mutation.png)

## Fragments
- Used to share logic between multiple queries or mutations
  ![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-fragment.png)

## Alias
- Used to rename the data that is returned in a query's results.
  ![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-alias.png)

## Mutation with input

- Input type to facilitate queries or mutations![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-input.png)

## Query variables
- Variables that can be used to receive via query![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-query-variables.png)

## Resolvers
- Using to interceptor any property
- Responsible for processing an solicitation and returning the requested data.

## POST API Graphql
![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-post-api-1.png)
![Alt text](https://raw.github.com/MelissaTeodoro/springboot_graphql/main/docs/assets/graphql-post-api-2.png)

## View schema json
http://localhost:8080/graphql/schema.json

## Queries and mutations to test

### Queries

- Find All Products

```graphql
{
  produtos {
    id, nome, valor
  }
}
```

- Find Product By Id
```graphql

{
  produto(id: 1) {
    id, nome, valor
  }
}
```
- Find All Clients
```graphql
{
  clientes {
    id, nome, email
  }
}
```

- Find All Clients and Compras
```graphql
{
  clientes {
    id, nome, email,
    compras {
      id, quantidade,
      produto {
        nome, valor
      }
    }
  }
}
```

- Find Client By Id
```graphql
{
  cliente(id: 1) {
    id, nome, email
  }
}
```

- Find All Clients by qtd Compras
```graphql
{
  clientes {
    id, nome, email,
    comprasByQtd(quantidade:2) {
      id, quantidade,
      produto {
        id
      }
    }
  }
}
```

- Find All Compras
```graphql
{
  compras {
    id, quantidade, status,
    cliente {
      id, nome
    },
    produto {
      id, nome, valor
    }
  }
}
```

- Find Compra By Id
```graphql
{
  compra(id:1) {
    id, quantidade, status,
    cliente {
      id, nome
    },
    produto {
      id, nome, valor
    }
  }
}
```

- Find Client using Query Variable, Alias, and Fragments (Example)
```javascript
query getClient($id: ID!) {
  a: cliente(id: $id) {
    ...fragCliente
  }

}

fragment fragCliente on Cliente {
  id, nome, email
}
```

### Mutations

- Save or update Product by Id
```graphql
 mutation {
  saveProduto(produto: {id: 6, nome: "New", valor: 110}) {
    id, nome, valor
  }
}
```

- Delete Product By Id
```graphql
 mutation {
  deleteProduto(id:3)
}
```

- Save or update Client by Id
```graphql
mutation {
    saveCliente(cliente: {id:10, nome: "Mia", email: "rico@test.com"}) {
    id, nome, email
  }
}
```

- Delete Client By Id
```graphql
  mutation {
  deleteCliente(id: 2)
}
```

- Save or Update Compra
```graphql
 mutation {
  saveCompra(compra: {
    clienteId: 1,
    produtoId: 1,
    quantidade: 2,
    status: "OK"
  }) {
    id, quantidade, status
  }
}
```

- Delete Compra by Id
```graphql
mutation {
  deleteCompra(id: 1)
}
```