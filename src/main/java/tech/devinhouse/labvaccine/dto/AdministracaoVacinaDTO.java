package tech.devinhouse.labvaccine.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AdministracaoVacinaDTO {
    private String nomeVacina;
    private LocalDateTime dataHoraAdministracao;
    private String tipoVacina;
    private int quantidade;
    private String observacoes;
    private Long clienteId;
    private Long farmaceuticoId;
}