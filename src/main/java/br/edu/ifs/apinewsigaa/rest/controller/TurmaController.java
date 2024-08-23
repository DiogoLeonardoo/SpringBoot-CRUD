package br.edu.ifs.apinewsigaa.rest.controller;

import br.edu.ifs.apinewsigaa.exception.ObjectNotFoundException;
import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.model.TurmaModel;
import br.edu.ifs.apinewsigaa.repository.TurmaRepository;
import br.edu.ifs.apinewsigaa.rest.dto.ApiResponse;
import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import br.edu.ifs.apinewsigaa.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TurmaDto>>> ObterTodos() {
        List<TurmaDto> turmaDtoList = turmaService.ObterTodos();
        String message = turmaDtoList.isEmpty() ? "Nenhuma turma encontrada!" : "Turmas encontradas com sucesso!";
        ApiResponse<List<TurmaDto>> response = new ApiResponse<>(UUID.randomUUID().toString(), message, turmaDtoList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TurmaDto>> ObterPorId(@PathVariable("id") int id) {
        TurmaModel turmaModel = turmaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Turma não encontrada com o ID: " + id));
        TurmaDto turmaDto = turmaModel.toDTO();
        ApiResponse<TurmaDto> response = new ApiResponse<>(UUID.randomUUID().toString(), "Turma encontrada com sucesso!", turmaDto);
        return ResponseEntity.ok(response);
    }




}
