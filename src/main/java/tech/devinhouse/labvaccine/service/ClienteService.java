package tech.devinhouse.labvaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labvaccine.dto.ClienteDTO;
import tech.devinhouse.labvaccine.dto.ClienteUpdateDTO;
import tech.devinhouse.labvaccine.model.Cliente;
import tech.devinhouse.labvaccine.model.EstadoCivil;
import tech.devinhouse.labvaccine.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarClientesPorNome(String nome) {
        return clienteRepository.findByNomeCompletoContaining(nome);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id));
    }

    public Cliente cadastrarCliente(ClienteDTO clienteDTO) {
        if (clienteRepository.existsByCpf(clienteDTO.getCpf())) {
            throw new CPFJaCadastradoException("CPF já cadastrado no sistema: " + clienteDTO.getCpf());
        }

        Cliente cliente = new Cliente();
        preencherClienteComDTO(cliente, clienteDTO);

        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Long id, ClienteUpdateDTO clienteUpdateDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id));

        updateClienteComDTO(clienteExistente, clienteUpdateDTO);

        return clienteRepository.save(clienteExistente);
    }

    private void preencherClienteComDTO(Cliente cliente, ClienteDTO clienteDTO) {
        cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
        cliente.setGenero(clienteDTO.getGenero());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setRg(clienteDTO.getRg());
        cliente.setEstadoCivil(EstadoCivil.valueOf(clienteDTO.getEstadoCivil()));
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNaturalidade(clienteDTO.getNaturalidade());
        cliente.setContatoEmergencia(clienteDTO.getContatoEmergencia());
        cliente.setAlergias(clienteDTO.getAlergias());
        cliente.setConvenio(clienteDTO.getConvenio());
        cliente.setNumeroCarteiraConvenio(clienteDTO.getNumeroCarteiraConvenio());
        cliente.setValidadeCarteiraConvenio(clienteDTO.getValidadeCarteiraConvenio());
    }

    private void updateClienteComDTO(Cliente cliente, ClienteUpdateDTO clienteUpdateDTO) {

        cliente.setContatoEmergencia(clienteUpdateDTO.getContatoEmergencia());
        cliente.setAlergias(clienteUpdateDTO.getAlergias());
        cliente.setConvenio(clienteUpdateDTO.getConvenio());
        cliente.setNumeroCarteiraConvenio(clienteUpdateDTO.getNumeroCarteiraConvenio());
    }
}
