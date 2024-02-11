package tech.devinhouse.labvaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labvaccine.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCpf(String cpf);
}
