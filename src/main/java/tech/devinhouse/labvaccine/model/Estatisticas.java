package tech.devinhouse.labvaccine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estatisticas {
    private long totalClientes;
    private long totalAdministracoesVacina;
}
