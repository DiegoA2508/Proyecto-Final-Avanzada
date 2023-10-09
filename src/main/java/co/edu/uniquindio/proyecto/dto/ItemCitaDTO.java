package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaDTO(

        int codigo,
        EstadoCita estadoCita,
        LocalDateTime fecha,
        String nombrePaciente,
        String nombreMedico
    ){
}
