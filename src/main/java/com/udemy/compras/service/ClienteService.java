package com.udemy.compras.service;

import com.udemy.compras.entity.Cliente;
import com.udemy.compras.repository.ClienteRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Cacheable("clientes")
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
