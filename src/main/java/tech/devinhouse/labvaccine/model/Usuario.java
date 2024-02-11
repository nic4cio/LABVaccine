package tech.devinhouse.labvaccine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario extends Pessoa {

    @Column(nullable = false, unique = true)
    private String crfUf;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataFormacao;

    @Column(nullable = false)
    private String senha;
}