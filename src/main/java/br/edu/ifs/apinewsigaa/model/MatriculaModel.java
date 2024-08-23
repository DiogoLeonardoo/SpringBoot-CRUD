package br.edu.ifs.apinewsigaa.model;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "matricula")
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "idAluno", nullable = false)
    private AlunoModel aluno;



    @ManyToMany
    @JoinTable(
            name = "turma_matricula",
            joinColumns = @JoinColumn(name = "matricula_id"),
            inverseJoinColumns = @JoinColumn(name = "turma_id"))

    private List<TurmaModel> turmas;
}
