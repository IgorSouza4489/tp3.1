package com.example.tp3.service;

import com.example.tp3.model.Aluno;
import com.example.tp3.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}
