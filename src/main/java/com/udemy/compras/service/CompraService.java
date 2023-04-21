package com.udemy.compras.service;

import com.udemy.compras.entity.Cliente;
import com.udemy.compras.entity.Compra;
import com.udemy.compras.exceptions.DomainException;
import com.udemy.compras.repository.CompraRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value = "comprasByCliente", key = "#compra.cliente.id")
    public Compra save(Compra compra) {
        if(compra.getQuantidade() > 100) {
            throw new DomainException("Não é possível fazer uma compra com mais de 100 itens!");
        }
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

    @Cacheable(value = "comprasByCliente", key = "#cliente.id")
    public List<Compra> findAllByCliente(final Cliente cliente) {
        return repository.findAllByCliente(cliente);
    }

    public List<Compra> findAllByClienteAndQuantidade(final Cliente cliente, final int quantidade) {
        return repository.findAllByClienteAndQuantidade(cliente, quantidade);
    }
}
