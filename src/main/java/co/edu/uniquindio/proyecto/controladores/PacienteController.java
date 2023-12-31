package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroPacienteDTO pacienteDTO) throws Exception{
        pacienteServicio.registrarse(pacienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente registrado correctamente"));
    }

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO pacienteDTO) throws Exception{
        pacienteServicio.editarPerfil(pacienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente actualizado correctamete") );
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigo) throws Exception{
        pacienteServicio.eliminarCuenta(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente eliminado correctamete")
        );
    }

    @GetMapping("/detalle/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePacienteDTO>> verDetallePaciente(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.verDetallePaciente(codigo)) );
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<MensajeDTO<List<ItemPacienteDTO>>> listarTodos(){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.listarTodos()) );
    }
}
