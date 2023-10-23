package co.edu.uniquindio.proyecto.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public record ValidacionDTO(
        String Campo,
        String Error
    ){
}
