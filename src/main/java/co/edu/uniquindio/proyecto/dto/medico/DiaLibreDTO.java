package co.edu.uniquindio.proyecto.dto.medico;

import java.time.LocalDateTime;

public record DiaLibreDTO(
        int codigoMedico,
        LocalDateTime fecha
) {
}
