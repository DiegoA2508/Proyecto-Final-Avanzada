package co.edu.uniquindio.proyecto.dto.admin;

import co.edu.uniquindio.proyecto.modelo.enums.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enums.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RegistroMedicoDTO(
        @NotNull
        @Length(max = 200)
        String nombre,
        @NotNull
        @Length(max = 10)
        String cedula,
        @NotNull
        Ciudad ciudad,
        @NotNull
        Especialidad especialidad,
        @NotNull
        @Length(max = 20)
        String telefono,
        @NotNull
        @Length(max = 80)
        String correo,
        @NotNull
        String password,
        @NotBlank
        String urlFoto,
        @NotEmpty
        List<HorarioDTO> horarios

) {
}
