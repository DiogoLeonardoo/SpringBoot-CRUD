package br.edu.ifs.apinewsigaa.service;

import br.edu.ifs.apinewsigaa.exception.DataIntegrityException;
import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.AlunoModel;
import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.repository.AlunoRepository;
import br.edu.ifs.apinewsigaa.repository.ProfessorRepository;
import br.edu.ifs.apinewsigaa.rest.dto.AlunoDto;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Transactional(readOnly = true)
    public List<ProfessorDto> ObterTodos() {
        List<ProfessorModel> professorList  = professorRepository.findAll();

        return professorList.stream()
                .map(professor -> professor.toDTO())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProfessorDto ObterPorMatricula(String matricula) {
        Optional<ProfessorModel> professorOptional = professorRepository.findByMatricula(matricula);
        ProfessorModel professorModel = professorOptional.orElseThrow(() ->
                new ObjectNotFoundException("ERRO: Matrícula não encontrada! Matrícula: " + matricula));

        return professorModel.toDTO();
    }

    @Transactional
    public ProfessorDto salvar (ProfessorModel novoProfessor){
        try {
            if(professorRepository.existsByMatricula(novoProfessor.getMatricula()) || professorRepository.existsByCpf(novoProfessor.getCpf())) {
                throw new DataIntegrityException("Já existe um professor cadastrado com o CPF ou matrícula fornecida.");
            }
            return professorRepository.save(novoProfessor).toDTO();

        }catch (DataIntegrityException e){
            throw new DataIntegrityException("Erro ao criar um novo professor.");
        }
    }

    @Transactional
    public ProfessorDto atualizar (ProfessorModel professorExistente){
        try {
            if (!professorRepository.existsById(professorExistente.getId())){
                throw new ObjectNotFoundException("Professor não encontrado com o ID: " + professorExistente.getId());
            }
            return professorRepository.save(professorExistente).toDTO();

        } catch (DataIntegrityException e){
            throw new DataIntegrityException("Erro ao atualizar um professor.");
        }
    }

    //Delete somente com o ID
    @Transactional
    public void deletar(int id){
        try {
            if (!professorRepository.existsById(id)){
                throw new ObjectNotFoundException("Professor não encontrado com o ID: " + id);
            }
            professorRepository.deleteById(id);

        }catch (DataIntegrityException e){
            throw new DataIntegrityException("Erro ao deletar um professor.");
        }
    }

    //Delete com a matrícula
    @Transactional
    public void deleteByMatricula(String matricula){
        try {
            if (!professorRepository.existsByMatricula(matricula)){
                throw new ObjectNotFoundException("Professor não encontrado com a matrícula: " + matricula);
            }
            professorRepository.deleteByMatricula(matricula);

        }catch (DataIntegrityException e){
            throw new DataIntegrityException("Erro ao deletar um professor.");
        }
    }


}
