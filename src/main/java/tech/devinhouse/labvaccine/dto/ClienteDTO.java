package tech.devinhouse.labvaccine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tech.devinhouse.labvaccine.model.Endereco;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO extends PessoaDTO {

    @NotBlank(message = "Contato de emergência é obrigatório")
    private String contatoEmergencia;

    private String alergias;

    private String convenio;

    private String numeroCarteiraConvenio;

    private Date validadeCarteiraConvenio;

    private Endereco endereco;

}
