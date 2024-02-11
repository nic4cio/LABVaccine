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
public class Cliente extends Pessoa {

    @Column(nullable = false)
    private String contatoEmergencia;

    @Column
    private String alergias;

    @Column
    private String convenio;

    @Column
    private String numeroCarteiraConvenio;

    @Column
    @Temporal(TemporalType.DATE)
    private Date validadeCarteiraConvenio;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
