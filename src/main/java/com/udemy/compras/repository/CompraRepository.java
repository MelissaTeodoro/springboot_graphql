package com.udemy.compras.repository;

import com.udemy.compras.entity.Cliente;
import com.udemy.compras.entity.Compra;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByCliente(Cliente cliente);

    List<Compra> findAllByClienteAndQuantidade(Cliente cliente, int quantidade);
}
