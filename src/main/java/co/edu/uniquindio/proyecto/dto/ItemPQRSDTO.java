package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record ItemPQRSDTO(
        EstadoPQRS estado,
        String motivo,
        int codigoPQRS,
        LocalDateTime fecha,
        String nombrePaciente){
}
