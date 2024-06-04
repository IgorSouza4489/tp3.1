package com.example.tp3.service;

import com.example.tp3.model.MaterialDidatico;
import com.example.tp3.repository.MaterialDidaticoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoService {

    private final MaterialDidaticoRepository repository;

    public MaterialDidaticoService(MaterialDidaticoRepository repository) {
        this.repository = repository;
    }

    public MaterialDidatico save(MaterialDidatico material) {
        return repository.save(material);
    }

    public Optional<MaterialDidatico> findById(String id) {
        return repository.findById(id);
    }

    public List<MaterialDidatico> findAll() {
        return repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
