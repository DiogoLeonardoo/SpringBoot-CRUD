package br.edu.ifs.apinewsigaa.model;

import br.edu.ifs.apinewsigaa.rest.dto.AlunoDto;
import br.edu.ifs.apinewsigaa.rest.dto.DisciplinaDto;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@Entity
@Table(name = "disciplina")
public class DisciplinaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;
    @Column(name = "numeroCreditos", nullable = false)
    private int numeroCreditos;

    @OneToMany(mappedBy = "disciplina")
    private List<TurmaModel> turmas;

    public DisciplinaDto toDTO(){
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(this, DisciplinaDto.class);
    }





}
