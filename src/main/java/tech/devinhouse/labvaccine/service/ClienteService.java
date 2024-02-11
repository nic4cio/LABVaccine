package tech.devinhouse.labvaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labvaccine.dto.ClienteDTO;
import tech.devinhouse.labvaccine.dto.ClienteUpdateDTO;
import tech.devinhouse.labvaccine.model.Cliente;
import tech.devinhouse.labvaccine.model.EstadoCivil;
import tech.devinhouse.labvaccine.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(ClienteDTO clienteDTO) {
        if (clienteRepository.existsByCpf(clienteDTO.getCpf())) {
            throw new CPFJaCadastradoException("CPF já cadastrado no sistema: " + clienteDTO.getCpf());
        }

        Cliente cliente = new Cliente();
        preencherClienteComDTO(cliente, clienteDTO);

        return clienteRepository.save(cliente);
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
}
