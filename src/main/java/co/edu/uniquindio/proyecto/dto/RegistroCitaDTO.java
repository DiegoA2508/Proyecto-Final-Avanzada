package co.edu.uniquindio.proyecto.dto;

import java.time.LocalDateTime;

public record RegistroCitaDTO(
        int codigoPaciente,
        LocalDateTime fechaCita,
        int codigoMedico,
        String motivo
    ){
}
