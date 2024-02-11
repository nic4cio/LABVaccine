package tech.devinhouse.labvaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labvaccine.model.Usuario;
import tech.devinhouse.labvaccine.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new CPFJaCadastradoException("CPF já cadastrado no sistema: " + usuario.getCpf());
        }

        return usuarioRepository.save(usuario);
    }
}
