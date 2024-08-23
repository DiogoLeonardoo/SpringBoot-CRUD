package br.edu.ifs.apinewsigaa.repository;

import br.edu.ifs.apinewsigaa.model.DisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Integer> {

    Optional<DisciplinaModel> findByNome(String nome);
    Optional<DisciplinaModel> findById(int id);

}
