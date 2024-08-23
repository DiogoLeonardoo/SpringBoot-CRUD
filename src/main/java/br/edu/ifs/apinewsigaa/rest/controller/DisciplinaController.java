package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.model.TurmaModel;
import br.edu.ifs.apinewsigaa.repository.TurmaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.ApiResponse;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaComAlunosDTO;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import br.edu.ifs.apinewsigaa.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<DisciplinaDto>>> ObterTodas() {
        List<DisciplinaDto> disciplinaDtoList = disciplinaService.ObterTodas();
        String message = disciplinaDtoList.isEmpty() ? "Nenhuma disciplina encontrada!" : "Disciplinas encontradas com sucesso!";
        ApiResponse<List<DisciplinaDto>> response = new ApiResponse<>(UUID.randomUUID().toString(), message, disciplinaDtoList);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DisciplinaDto>> ObterDisciplinaPorId(@PathVariable Integer id) {
        DisciplinaModel disciplina = disciplinaService.ObterDisciplinaPorId(id);
        if (disciplina == null) {
            return ResponseEntity.notFound().build();
        }
        DisciplinaDto disciplinaDto = disciplina.toDTO();
        ApiResponse<DisciplinaDto> response = new ApiResponse<>(UUID.randomUUID().toString(), "Disciplina encontrada com sucesso!", disciplinaDto);
        return ResponseEntity.ok(response);
    }

     /* Questão 02 da prova de Programação 1 (Controller) */

    @GetMapping("/com-alunos")
    public ResponseEntity<ApiResponse<List<DisciplinaComAlunosDTO>>> ObterDisciplinasComAlunos() {
        List<DisciplinaComAlunosDTO> disciplinasComAlunos = disciplinaService.ObterDisciplinasComAlunos();
        String message = disciplinasComAlunos.isEmpty() ? "Nenhuma disciplina encontrada!" : "Disciplinas encontradas com sucesso!";
        ApiResponse<List<DisciplinaComAlunosDTO>> response = new ApiResponse<>(UUID.randomUUID().toString(), message, disciplinasComAlunos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/com-alunos")
    public ResponseEntity<ApiResponse<DisciplinaComAlunosDTO>> ObterDisciplinaComAlunosPorId(@PathVariable Integer id) {
        DisciplinaComAlunosDTO disciplinaComAlunos = disciplinaService.ObterDisciplinaComAlunosPorId(id);
        if (disciplinaComAlunos == null) {
            return ResponseEntity.notFound().build();
        }
        String message = "Disciplina com alunos encontrada com sucesso!";
        ApiResponse<DisciplinaComAlunosDTO> response = new ApiResponse<>(UUID.randomUUID().toString(), message, disciplinaComAlunos);
        return ResponseEntity.ok(response);
    }
}
