package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(unique = true,nullable = false,updatable = false)
    private int codigo;

    private LocalDateTime fechaCreacion;

    @Column(nullable = false,updatable = false)
    private String mensaje;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PQRS codigoPQRS;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cuenta codigoCuenta;

    @OneToOne
    @JoinColumn(nullable = false)
    private Mensaje codigoMensaje;

}
