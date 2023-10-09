package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enums.EPS;
import co.edu.uniquindio.proyecto.modelo.enums.TipoSangre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paciente extends Usuario implements Serializable{

    private Date fechaNacimiento;

    @Column(nullable = false,length = 40)
    private String alergias;

    @Enumerated(EnumType.STRING)
    private EPS codigoEPS;

    @Enumerated(EnumType.STRING)
    private TipoSangre codigoTipoSangre;

    @OneToMany(mappedBy = "codigoPaciente")
    private List<Cita> listaCitas;

}
