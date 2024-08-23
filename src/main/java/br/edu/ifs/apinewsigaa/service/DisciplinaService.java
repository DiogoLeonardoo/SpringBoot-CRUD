package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.model.*;
import br.edu.ifs.apinewsigaa.repository.DisciplinaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaComAlunosDTO;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import br.edu.ifs.apinewsigaa.repository.TurmaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifs.apinewsigaa.rest.dto.AlunoDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    //Método da questão 1 avaliação

    public List<DisciplinaDto> ObterDisciplinasPorProfessor(String matricula) {
        List<TurmaModel> turmas = turmaRepository.findByProfessor_Matricula(matricula);
        return turmas.stream()
                .map(turma -> turma.getDisciplina().toDTO())
                .collect(Collectors.toList());
    }

    public List <DisciplinaModel> ObterDisciplinaPorIds(List<Integer> discplinaIds) {
        return disciplinaRepository.findAllById(discplinaIds);
    }


    public DisciplinaModel ObterDisciplinaPorId(Integer id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<DisciplinaDto> ObterTodas() {
        List<DisciplinaModel> discplinaList  = disciplinaRepository.findAll();

        return discplinaList.stream()
                .map(discplina -> discplina.toDTO())
                .collect(Collectors.toList());
    }

    // Obter disciplinas com alunos

    public List<DisciplinaComAlunosDTO> ObterDisciplinasComAlunos() {
        List<DisciplinaModel> disciplinas = disciplinaRepository.findAll();
        List<DisciplinaComAlunosDTO> disciplinasComAlunos = new ArrayList<>();

        for (DisciplinaModel disciplina : disciplinas) {
            DisciplinaComAlunosDTO disciplinaComAlunos = new DisciplinaComAlunosDTO();
            disciplinaComAlunos.setDisciplina(disciplina.toDTO());

            List<AlunoDto> alunos = new ArrayList<>();
            for (TurmaModel turma : disciplina.getTurmas()) {
                for (MatriculaModel matricula : turma.getMatriculas()) {
                    AlunoModel aluno = matricula.getAluno();
                    if (aluno != null) {
                        alunos.add(aluno.toDTO());
                    }
                }
            }

            disciplinaComAlunos.setAlunos(alunos);
            disciplinasComAlunos.add(disciplinaComAlunos);
        }

        return disciplinasComAlunos;
    }

    public DisciplinaComAlunosDTO ObterDisciplinaComAlunosPorId(Integer id) {
        DisciplinaModel disciplina = disciplinaRepository.findById(id).orElse(null);
        if (disciplina == null) {
            return null;
        }

        DisciplinaComAlunosDTO disciplinaComAlunos = new DisciplinaComAlunosDTO();
        disciplinaComAlunos.setDisciplina(disciplina.toDTO());

        List<AlunoDto> alunos = new ArrayList<>();
        for (TurmaModel turma : disciplina.getTurmas()) {
            for (MatriculaModel matricula : turma.getMatriculas()) {
                AlunoModel aluno = matricula.getAluno();
                if (aluno != null) {
                    alunos.add(aluno.toDTO());
                }
            }
        }

        disciplinaComAlunos.setAlunos(alunos);
        return disciplinaComAlunos;
    }


}