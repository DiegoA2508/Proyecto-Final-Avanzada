package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record CitasAdminDTO(

        int codigo,
        EstadoCita estadoCita,
        LocalDateTime fecha,
        String nombrePaciente,
        String nombreMedico
) {
}
