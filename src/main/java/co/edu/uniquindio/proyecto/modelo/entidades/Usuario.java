package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enums.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enums.Estado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable {

    @Column(unique = true,nullable = false,updatable = false)
    private String cedula;

    @Column(nullable = false,length = 40)
    private String nombre;

    @Column(nullable = false,length = 12)
    private String telefono;

    @Column(nullable = false,length = 500)
    private String urlFoto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ciudad ciudad;

    @Enumerated(EnumType.STRING)
    private Estado estadoUsuario;

}
