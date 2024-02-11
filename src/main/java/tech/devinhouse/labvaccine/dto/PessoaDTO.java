package tech.devinhouse.labvaccine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String genero;

    @NotNull
    private Date dataNascimento;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

    @NotBlank
    private String estadoCivil;

    @NotBlank
    private String telefone;

    @NotBlank
    private String email;

    @NotBlank
    private String naturalidade;

}

