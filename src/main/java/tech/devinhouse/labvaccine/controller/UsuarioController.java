package tech.devinhouse.labvaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labvaccine.dto.UsuarioDTO;
import tech.devinhouse.labvaccine.dto.UsuarioUpdateDTO;
import tech.devinhouse.labvaccine.model.Usuario;
import tech.devinhouse.labvaccine.service.CPFJaCadastradoException;
import tech.devinhouse.labvaccine.service.UsuarioNaoEncontradoException;
import tech.devinhouse.labvaccine.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario novoUsuario = usuarioService.cadastrarUsuario(usuarioDTO);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (CPFJaCadastradoException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar usuário: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {
        try {
            Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioUpdateDTO);
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (UsuarioNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar usuário: " + ex.getMessage());
        }
    }
}
