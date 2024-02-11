package tech.devinhouse.labvaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labvaccine.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
