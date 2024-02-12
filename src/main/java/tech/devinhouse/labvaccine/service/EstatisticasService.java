package tech.devinhouse.labvaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labvaccine.model.Estatisticas;
import tech.devinhouse.labvaccine.repository.ClienteRepository;
import tech.devinhouse.labvaccine.repository.AdministracaoVacinaRepository;

@Service
public class EstatisticasService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AdministracaoVacinaRepository administracaoVacinaRepository;

    public Estatisticas getEstatisticas() {
        long totalClientes = clienteRepository.count();
        long totalAdministracoesVacina = administracaoVacinaRepository.count();
        return new Estatisticas(totalClientes, totalAdministracoesVacina);
    }
}
