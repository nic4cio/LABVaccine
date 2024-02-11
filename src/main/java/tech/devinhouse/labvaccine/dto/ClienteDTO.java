package tech.devinhouse.labvaccine.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ClienteDTO extends PessoaDTO {

    @NotNull(message = "Data de Cadastro é obrigatória")
    private Date dataCadastro;

    @NotEmpty(message = "Endereço é obrigatório")
    private String endereco;
}

