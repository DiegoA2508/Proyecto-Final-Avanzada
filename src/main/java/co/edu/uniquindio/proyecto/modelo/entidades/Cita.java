package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enums.Estado;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.management.ConstructorParameters;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(unique = true,nullable = false,updatable = false)
    private int codigo;

    @Column(nullable = false)
    @DateTimeFormat
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    @DateTimeFormat
    private LocalDateTime fechaCita;

    @Column(updatable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Paciente codigoPaciente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Medico codigoMedico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estadoCita;

    @OneToOne
    @JoinColumn(nullable = false)
    private Atencion atencionCita;
}
