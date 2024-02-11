package tech.devinhouse.labvaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labvaccine.model.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);
    List<Cliente> findByNomeCompletoContaining(String nome);
}
