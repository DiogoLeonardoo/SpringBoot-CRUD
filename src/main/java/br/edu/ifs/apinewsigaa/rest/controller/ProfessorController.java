package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDisciplinaDTO;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import br.edu.ifs.apinewsigaa.rest.dto.ApiResponse;
import br.edu.ifs.apinewsigaa.service.ProfessorService;
import br.edu.ifs.apinewsigaa.repository.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.ifs.apinewsigaa.service.DisciplinaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService ProfessorService;

    @Autowired
    private ProfessorRepository ProfessorRepository;

    @Autowired
    private DisciplinaService DisciplinaService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<ProfessorDto>>> ObterTodos() {
        List<ProfessorDto> professorDtoList = ProfessorService.ObterTodos();
        String message = professorDtoList.isEmpty() ? "Nenhum professor encontrado!" : "Professores encontrados com sucesso!";
        ApiResponse<List<ProfessorDto>> response = new ApiResponse<>(UUID.randomUUID().toString(), "Professores encontrados com sucesso!", professorDtoList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProfessorDto>> ObterPorId(@PathVariable("id") int id) {
        ProfessorModel professorModel = ProfessorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado com o ID: " + id));
        ProfessorDto professorDto = professorModel.toDTO();
        ApiResponse<ProfessorDto> response = new ApiResponse<>(UUID.randomUUID().toString(), "Professor encontrado com sucesso!", professorDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByMat/{mat}")
    public ResponseEntity<ApiResponse<ProfessorDto>> ObterPorMatricula(@PathVariable("mat") String matricula) {
        ProfessorDto professorDto = ProfessorService.ObterPorMatricula(matricula);
        ApiResponse<ProfessorDto> response = new ApiResponse<>(UUID.randomUUID().toString(), "Professor encontrado com sucesso!", professorDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProfessorDto>> Salvar(@RequestBody @Valid ProfessorModel novoProfessor) {
        ProfessorDto professorDto = ProfessorService.salvar(novoProfessor);
        ApiResponse<ProfessorDto> response = new ApiResponse<>(UUID.randomUUID().toString(), "Professor criado com sucesso!", professorDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<ProfessorDto>> Atualizar(@RequestBody @Valid ProfessorModel professorExistente) {
        ProfessorDto professorDto = ProfessorService.atualizar(professorExistente);
        ApiResponse<ProfessorDto> response = new ApiResponse<>(UUID.randomUUID().toString(), "Professor atualizado com sucesso!", professorDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletar(@PathVariable int id) {
        ProfessorService.deletar(id);
        ApiResponse<Void> response = new ApiResponse<>(UUID.randomUUID().toString(), "Professor deletado com sucesso!", null);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar/{matricula}")
    public ResponseEntity<ApiResponse<Void>> deleteByMatricula(@PathVariable String matricula) {
        ProfessorService.deleteByMatricula(matricula);
        ApiResponse<Void> response = new ApiResponse<>(UUID.randomUUID().toString(), "Professor deletado com sucesso!", null);
        return ResponseEntity.ok(response);
    }

    // 01) Controller da primeira questão da avaliação

    @GetMapping("/ObterDisciplinasPorProfessor/{matricula}")
    public ResponseEntity<ApiResponse<ProfessorDisciplinaDTO>> ObterProfessorEDisciplinas(@PathVariable("matricula") String matricula) {
        ProfessorDto professorDto = ProfessorService.ObterPorMatricula(matricula);
        List<DisciplinaDto> disciplinaDtoList = DisciplinaService.ObterDisciplinasPorProfessor(matricula);
        ProfessorDisciplinaDTO professorDisciplinaDTO = new ProfessorDisciplinaDTO();
        professorDisciplinaDTO.setProfessor(professorDto);
        professorDisciplinaDTO.setDisciplinas(disciplinaDtoList);
        ApiResponse<ProfessorDisciplinaDTO> response = new ApiResponse<>(UUID.randomUUID().toString(), "Professor e disciplinas encontrados com sucesso!", professorDisciplinaDTO);
        return ResponseEntity.ok(response);
    }



}
