package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enums.EstadoCita;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record ItemCitaDTO(

        @Positive
        int codigo,

        @NotEmpty
        @Length(max=20)
        EstadoCita estadoCita,

        @NotEmpty
        LocalDateTime fecha,

        @NotEmpty
        @Length(max=50)
        String nombrePaciente,

        @NotEmpty
        @Length(max=50)
        String nombreMedico
    ){
}
