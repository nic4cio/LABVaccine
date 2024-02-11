package tech.devinhouse.labvaccine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteUpdateDTO extends PessoaDTO {

    private String contatoEmergencia;

    private String alergias;

    private String convenio;

    private String numeroCarteiraConvenio;

    private Date validadeCarteiraConvenio;

}
