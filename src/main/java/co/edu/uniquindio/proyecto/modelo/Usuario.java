package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Usuario extends Cuenta implements Serializable {

    @Id
    private String codigo;

    private String cedula;
    private String nombre;
    private String telefono;
    private String urlFoto;

}
