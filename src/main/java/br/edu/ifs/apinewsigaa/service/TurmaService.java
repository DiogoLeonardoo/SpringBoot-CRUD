package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.model.TurmaModel;
import br.edu.ifs.apinewsigaa.repository.TurmaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<TurmaModel> obterTurmas() {
        return turmaRepository.findAll();
    }

    public List<TurmaModel> obterTurmasPorProfessor(ProfessorModel professor) {
        return turmaRepository.findByProfessor_Matricula(professor.getMatricula());
    }

    public List<TurmaDto> ObterTodos() {
        List<TurmaModel> turmaModels = turmaRepository.findAll();
        List<TurmaDto> turmaDtos = new ArrayList<>();

        for (TurmaModel turmaModel : turmaModels) {
            TurmaDto turmaDto = turmaModel.toDTO();
            turmaDtos.add(turmaDto);
        }

        return turmaDtos;
    }


}
