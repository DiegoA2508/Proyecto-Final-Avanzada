package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record DetallePQRSDTO(
        int codigo,
        LocalDateTime fecha,
        EstadoPQRS estadoPQRS

) {
}
