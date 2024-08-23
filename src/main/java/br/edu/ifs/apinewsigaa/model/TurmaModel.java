package br.edu.ifs.apinewsigaa.model;

import br.edu.ifs.apinewsigaa.rest.dto.ProfessorDto;
import br.edu.ifs.apinewsigaa.rest.dto.TurmaDto;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "turma")
public class TurmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dataInicio", nullable = false)
    private Date dataInicio;
    @Column(name = "dataFim", nullable = true)
    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "idProfessor", nullable = false)
    private ProfessorModel professor;

    @ManyToOne
    @JoinColumn(name = "idDisciplina", nullable = false)
    private DisciplinaModel disciplina;

    @ManyToMany(mappedBy = "turmas")
    private List<MatriculaModel> matriculas;

    public TurmaDto toDTO(){
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(this, TurmaDto.class);
    }
}