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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final CitaRepo citaRepo;


    @Override
    public List<ItemCitaAdminDTO> listarCitasPendientes(int codigoMedico) throws Exception {

        List<Cita> citas = citaRepo.findAll();
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        Cita cita = new Cita();

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

        Optional<Cita> optional = citaRepo.findById(Integer.valueOf(registroAtencioDTO.codigoCita()));

        if( optional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+registroAtencioDTO.codigoCita());
        }

        Cita cita = optional.get();

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
