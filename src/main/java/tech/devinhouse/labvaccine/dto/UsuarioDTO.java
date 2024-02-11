package tech.devinhouse.labvaccine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO extends PessoaDTO {

    @NotEmpty(message = "CRF/UF é obrigatório")
    private String crfUf;

    @NotNull(message = "Data de Formação é obrigatória")
    private Date dataFormacao;

    @NotEmpty(message = "Senha é obrigatória")
    private String senha;
}

