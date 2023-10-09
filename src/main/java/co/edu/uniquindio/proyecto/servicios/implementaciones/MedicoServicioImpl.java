package co.edu.uniquindio.proyecto.servicios.implementaciones;

import co.edu.uniquindio.proyecto.dto.ItemCitaDTO;
import co.edu.uniquindio.proyecto.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.proyecto.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.proyecto.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.enums.EstadoCita;
import co.edu.uniquindio.proyecto.repositorios.CitaRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final CitaRepo citaRepo;
    private Cita cita;

    @Override
    public List<ItemCitaAdminDTO> listarCitasPendientes(int codigoMedico) throws Exception {

        List<Cita> citas = citaRepo.findAll();
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        if(cita.getCodigoMedico().getCodigo()==codigoMedico) {
            if (cita.getEstadoCita().equals(EstadoCita.PENDIENTE)) {
                for (Cita c : citas) {
                    respuesta.add(new ItemCitaAdminDTO(
                            c.getCodigo(),
                            c.getCodigoPaciente().getNombre(),
                            c.getCodigoPaciente().getNombre(),
                            c.getCodigoMedico().getNombre(),
                            c.getCodigoMedico().getEspecialidad(),
                            c.getEstadoCita(),
                            c.getFechaCita()
                    ));
                }
            }
        }else{
            throw new Exception("No existen citas pendientes");
        }
        return respuesta;
    }

    @Override
    public int atenderCita(RegistroAtencionDTO registroAtencioDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarHistorialAtencionPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) {
        return null;
    }
}
