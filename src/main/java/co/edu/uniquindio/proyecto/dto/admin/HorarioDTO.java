package co.edu.uniquindio.proyecto.dto.admin;

import java.time.LocalTime;

public record HorarioDTO (

        String dia,
        LocalTime horaInicio,
        LocalTime horaFin
    ){
}