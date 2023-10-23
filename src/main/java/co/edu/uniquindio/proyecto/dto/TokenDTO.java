package co.edu.uniquindio.proyecto.dto;

import org.hibernate.validator.constraints.NotBlank;

public record TokenDTO(
        @NotBlank
        String token
    ){
}
