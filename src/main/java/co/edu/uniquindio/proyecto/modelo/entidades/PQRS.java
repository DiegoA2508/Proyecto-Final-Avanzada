package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enums.EstadoPQRS;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(unique = true,nullable = false,updatable = false)
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false,length = 50)
    private String tipo;

    @Column(nullable = false,length = 300)
    private String motivo;

    @ManyToOne
    @JoinColumn(unique = true,nullable = false)
    private Cita codigoCita;

    @Enumerated(EnumType.STRING)
    private EstadoPQRS estadoPQRS;

    @OneToMany(mappedBy = "codigoPQRS")
    private List<Mensaje> listamensaje;


}
