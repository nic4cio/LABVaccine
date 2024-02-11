package tech.devinhouse.labvaccine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovaSenhaDTO {
    @NotBlank(message = "A nova senha não pode estar em branco")
    private String novaSenha;
}
