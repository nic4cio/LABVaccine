package tech.devinhouse.labvaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labvaccine.dto.UsuarioDTO;
import tech.devinhouse.labvaccine.dto.UsuarioUpdateDTO;
import tech.devinhouse.labvaccine.model.EstadoCivil;
import tech.devinhouse.labvaccine.model.Usuario;
import tech.devinhouse.labvaccine.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsByCpf(usuarioDTO.getCpf())) {
            throw new CPFJaCadastradoException("CPF já cadastrado no sistema: " + usuarioDTO.getCpf());
        }

        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(usuarioDTO.getNomeCompleto());
        usuario.setGenero(usuarioDTO.getGenero());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setRg(usuarioDTO.getRg());
        usuario.setEstadoCivil(EstadoCivil.valueOf(usuarioDTO.getEstadoCivil()));
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNaturalidade(usuarioDTO.getNaturalidade());
        usuario.setCrfUf(usuarioDTO.getCrfUf());
        usuario.setDataFormacao(usuarioDTO.getDataFormacao());
        usuario.setSenha(usuarioDTO.getSenha());

        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com o ID: " + id));

        if (usuarioUpdateDTO.getCrfUf() != null) {
            usuarioExistente.setCrfUf(usuarioUpdateDTO.getCrfUf());
        }

        if (usuarioUpdateDTO.getDataFormacao() != null) {
            usuarioExistente.setDataFormacao(usuarioUpdateDTO.getDataFormacao());
        }

        return usuarioRepository.save(usuarioExistente);
    }
}
