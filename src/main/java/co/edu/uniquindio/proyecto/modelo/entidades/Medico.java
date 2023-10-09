package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enums.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enums.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medico extends Usuario implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Especialidad especialidad;

    @OneToMany(mappedBy = "codigoMedico")
    private List<Horario> horarios;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(mappedBy = "codigoMedico")
    private List<DiaLibre> diaLibre;

    @OneToMany(mappedBy = "codigoMedico")
    private List<Cita> citaMedico;
}
