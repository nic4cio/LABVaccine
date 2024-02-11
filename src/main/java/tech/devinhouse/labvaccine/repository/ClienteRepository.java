package tech.devinhouse.labvaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labvaccine.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);
}
