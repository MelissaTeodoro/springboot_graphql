package com.udemy.compras.controller.graphql.service;

import com.udemy.compras.entity.Cliente;
import com.udemy.compras.entity.Compra;
import com.udemy.compras.repository.CompraRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public Compra findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Compra> findAll(final PageRequest pageRequest) {
        return repository.findAll(pageRequest).getContent();
    }

    @Transactional
    public Compra save(Compra compra) {
        return repository.save(compra);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Compra> findAllByCliente(final Cliente cliente) {
        return repository.findAllByCliente(cliente);
    }

    public List<Compra> findAllByClienteAndQuantidade(final Cliente cliente, final int quantidade) {
        return repository.findAllByClienteAndQuantidade(cliente, quantidade);
    }
}
