package br.edu.ifs.apinewsigaa.rest.dto;

import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import br.edu.ifs.apinewsigaa.model.TurmaModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DisciplinaDto {

    private int id;
    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;
    @Column(name = "numeroCreditos", nullable = false)
    private int numeroCreditos;

    public DisciplinaModel toModel(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, DisciplinaModel.class);
    }

    public DisciplinaDto toDTO(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, DisciplinaDto.class);
    }


}
