package br.edu.ifs.apinewsigaa.repository;

import br.edu.ifs.apinewsigaa.model.ProfessorModel;
import br.edu.ifs.apinewsigaa.model.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, Integer> {

    List<TurmaModel> findByProfessor_Matricula(String matricula);

    Optional<TurmaModel> findById(int id);

    List<TurmaModel> findByProfessor(ProfessorModel professor);
}