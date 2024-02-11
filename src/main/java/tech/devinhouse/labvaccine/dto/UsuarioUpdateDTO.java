package tech.devinhouse.labvaccine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioUpdateDTO extends PessoaDTO {

    private String crfUf;

    private Date dataFormacao;
}
