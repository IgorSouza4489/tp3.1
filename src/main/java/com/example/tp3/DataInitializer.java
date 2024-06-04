package com.example.tp3;

import com.example.tp3.model.Aluno;
import com.example.tp3.model.Curso;
import com.example.tp3.model.MaterialDidatico;
import com.example.tp3.repository.AlunoRepository;
import com.example.tp3.repository.CursoRepository;
import com.example.tp3.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            Curso curso1 = new Curso();
            curso1.setNome("Gografia");
            Curso curso2 = new Curso();
            curso2.setNome("Física");
            cursoRepository.save(curso1);
            cursoRepository.save(curso2);

            Aluno aluno1 = new Aluno();
            aluno1.setNome("João");
            aluno1.getCursos().add(curso1);
            Aluno aluno2 = new Aluno();
            aluno2.setNome("Maria");
            aluno2.getCursos().add(curso2);
            alunoRepository.save(aluno1);
            alunoRepository.save(aluno2);

            MaterialDidatico material1 = new MaterialDidatico();
            material1.setTitulo("Livro de Matemática");
            //material1.setConteudo("Conteúdo de Matemática");
            MaterialDidatico material2 = new MaterialDidatico();
            material2.setTitulo("Livro de Português");
            //material2.setConteudo("Conteúdo de Português");
            materialDidaticoRepository.save(material1);
            materialDidaticoRepository.save(material2);
        };
    }
}