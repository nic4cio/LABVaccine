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

import javax.swing.text.html.Option;
import java.util.Optional;

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

    public AdministracaoVacina atualizarAdministracaoVacina(Long id, AdministracaoVacinaDTO administracaoVacinaDTO) {
        AdministracaoVacina administracaoVacina = administracaoVacinaRepository.findById(id)
                .orElseThrow(() -> new AdministracaoVacinaNaoEncontradaException("Administração de vacina não encontrada com o ID: " + id));

        if (administracaoVacinaDTO.getTipoVacina() == null || administracaoVacinaDTO.getObservacoes() == null) {
            throw new CamposObrigatoriosNaoFornecidosException("Os campos obrigatórios 'tipoVacina' e 'observacoes' devem ser fornecidos.");
        }

        administracaoVacina.setTipoVacina(TipoVacina.valueOf(administracaoVacinaDTO.getTipoVacina()));
        administracaoVacina.setObservacoes(administracaoVacinaDTO.getObservacoes());

        return administracaoVacinaRepository.save(administracaoVacina);
    }

    public AdministracaoVacina getAdministracaoVacinaById(Long id) {
        Optional<AdministracaoVacina> administracaoVacinaOptional = administracaoVacinaRepository.findById(id);
        return administracaoVacinaOptional.orElseThrow(() -> new AdministracaoVacinaNaoEncontradaException("Administração de vacina não encontrada com o ID: " + id));
    }
}