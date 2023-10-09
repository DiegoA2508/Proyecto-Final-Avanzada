package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Horario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(unique = true,nullable = false,updatable = false)
    private String codigo;

    @Column(nullable = false,updatable = false,length = 20)
    private String dia;

    @Column(nullable = false)
    @DateTimeFormat
    private LocalDateTime horaInicio;

    @Column(nullable = false)
    @DateTimeFormat
    private LocalDateTime horaFin;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Medico codigoMedico;

}
