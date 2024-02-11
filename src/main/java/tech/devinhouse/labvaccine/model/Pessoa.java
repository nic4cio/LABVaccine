package tech.devinhouse.labvaccine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nomeCompleto;

    @Column
    private String genero;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String rg;

    @Column
    private EstadoCivil estadoCivil;

    @Column
    private String telefone;

    @Column(unique = true)
    private String email;

    @Column
    private String naturalidade;
}
