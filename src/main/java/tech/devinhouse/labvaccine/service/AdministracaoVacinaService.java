package tech.devinhouse.labvaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labvaccine.dto.AdministracaoVacinaDTO;
import tech.devinhouse.labvaccine.model.AdministracaoVacina;
import tech.devinhouse.labvaccine.model.Cliente;
import tech.devinhouse.labvaccine.model.TipoVacina;
import tech.devinhouse.labvaccine.model.Usuario;
import tech.devinhouse.labvaccine.repository.AdministracaoVacinaRepository;
import tech.devinhouse.labvaccine.repository.ClienteRepository;
import tech.devinhouse.labvaccine.repository.UsuarioRepository;

@Service
public class AdministracaoVacinaService {

    @Autowired
    private AdministracaoVacinaRepository administracaoVacinaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public AdministracaoVacina cadastrarAdministracaoVacina(AdministracaoVacinaDTO administracaoVacinaDTO) {
        Cliente cliente = clienteRepository.findById(administracaoVacinaDTO.getClienteId())
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + administracaoVacinaDTO.getClienteId()));

        Usuario farmaceutico = usuarioRepository.findById(administracaoVacinaDTO.getFarmaceuticoId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Farmacêutico não encontrado com o ID: " + administracaoVacinaDTO.getFarmaceuticoId()));

        AdministracaoVacina administracaoVacina = new AdministracaoVacina();
        administracaoVacina.setNomeVacina(administracaoVacinaDTO.getNomeVacina());
        administracaoVacina.setDataHoraAdministracao(administracaoVacinaDTO.getDataHoraAdministracao());
        administracaoVacina.setTipoVacina(TipoVacina.valueOf(administracaoVacinaDTO.getTipoVacina()));
        administracaoVacina.setQuantidade(administracaoVacinaDTO.getQuantidade());
        administracaoVacina.setObservacoes(administracaoVacinaDTO.getObservacoes());
        administracaoVacina.setCliente(cliente);
        administracaoVacina.setFarmaceutico(farmaceutico);

        return administracaoVacinaRepository.save(administracaoVacina);
    }
}