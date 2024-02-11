package tech.devinhouse.labvaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labvaccine.dto.ClienteDTO;
import tech.devinhouse.labvaccine.dto.ClienteUpdateDTO;
import tech.devinhouse.labvaccine.model.Cliente;
import tech.devinhouse.labvaccine.service.ClienteNaoEncontradoException;
import tech.devinhouse.labvaccine.service.ClienteService;
import tech.devinhouse.labvaccine.service.CPFJaCadastradoException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            Cliente novoCliente = clienteService.cadastrarCliente(clienteDTO);
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
        } catch (CPFJaCadastradoException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar cliente: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable("id") Long id, @RequestBody ClienteUpdateDTO clienteUpdateDTO) {
        try {
            Cliente clienteAtualizado = clienteService.atualizarCliente(id, clienteUpdateDTO);
            return ResponseEntity.ok(clienteAtualizado);
        } catch (ClienteNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar cliente: " + ex.getMessage());
        }
    }

}