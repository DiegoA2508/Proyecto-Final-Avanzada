package co.edu.uniquindio.proyecto.dto;

import java.util.List;

public record DetalleMedicoDTO (
        String cedula,
        String nombre,
        String telefono,
        String ciudad,
            String correo,
            String especialidad,
            List<HorarioDTO> horarioDTO
    ){
}
