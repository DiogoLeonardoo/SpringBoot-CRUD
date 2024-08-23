package br.edu.ifs.apinewsigaa.rest.dto;
import lombok.Data;
import java.util.List;

public class DisciplinaComAlunosDTO {
    private DisciplinaDto disciplina;
    private List<AlunoDto> alunos;

    public DisciplinaDto getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaDto disciplina) {
        this.disciplina = disciplina;
    }

    public List<AlunoDto> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoDto> alunos) {
        this.alunos = alunos;
    }



}
