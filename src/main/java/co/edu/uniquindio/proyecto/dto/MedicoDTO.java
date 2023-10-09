package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.dto.admin.HorarioDTO;

import java.util.List;

public record MedicoDTO (
        String codigo,
        String cedula,
        String nombre,
        String telefono,
        String ciudad,
        String correo,
        String password,
        String especialidad,
        String urlFoto,
        List<HorarioDTO> horarioDTO
    ){

}
