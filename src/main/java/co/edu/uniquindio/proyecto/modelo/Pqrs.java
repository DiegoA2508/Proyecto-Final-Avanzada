package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pqrs {

    @Id
    private String fechaCreacion;
    private String tipo;
    private String motivo;
}
