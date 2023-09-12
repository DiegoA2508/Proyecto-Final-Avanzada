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
public class Paciente extends Usuario{

    @Id
    private String codigo;

    private String fechaNacimiento;
    private String alergias;

}
