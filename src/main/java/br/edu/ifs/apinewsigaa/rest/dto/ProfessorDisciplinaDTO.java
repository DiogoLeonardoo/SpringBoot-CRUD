package br.edu.ifs.apinewsigaa.rest.dto;

import java.util.List;

public class ProfessorDisciplinaDTO {

    private ProfessorDto professor;
    private List<DisciplinaDto> disciplinas;

    public ProfessorDto getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDto professor) {
        this.professor = professor;
    }

    public List<DisciplinaDto> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaDto> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
