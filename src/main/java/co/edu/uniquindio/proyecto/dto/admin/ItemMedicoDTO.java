package co.edu.uniquindio.proyecto.dto.admin;

import co.edu.uniquindio.proyecto.modelo.enums.Especialidad;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ItemMedicoDTO(
        @NotNull
        @Length(max=10)
        String cedula,
        @NotNull
        @Length(max=20)
        String nombre,
        @NotNull
        @Length(max=500)
        String urlFoto,
        @NotNull
        @Length(max=10)
        Especialidad especialidad
    ){
}
