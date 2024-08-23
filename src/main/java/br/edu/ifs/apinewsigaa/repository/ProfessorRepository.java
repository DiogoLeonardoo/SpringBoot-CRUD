package br.edu.ifs.apinewsigaa.repository;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Integer> {

    Optional<ProfessorModel> findByMatricula(String matricula);

    Boolean existsByMatricula(String matricula);

    Optional<ProfessorModel> deleteByMatricula(String matricula);

    Optional<ProfessorModel> findByCpf(String cpf);

    Boolean existsByCpf(String cpf);

    Optional<ProfessorModel> findById(int id);


}
