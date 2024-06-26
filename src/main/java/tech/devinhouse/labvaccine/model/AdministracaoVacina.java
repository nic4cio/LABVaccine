package tech.devinhouse.labvaccine.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdministracaoVacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeVacina;

    @Column(nullable = false)
    private LocalDateTime dataHoraAdministracao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoVacina tipoVacina;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "farmaceutico_id", nullable = false)
    private Usuario farmaceutico;
}
