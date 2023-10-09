package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ItemCitaDTO;
import co.edu.uniquindio.proyecto.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.proyecto.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.proyecto.dto.medico.RegistroAtencionDTO;

import java.util.List;

public interface MedicoServicio {

    List<ItemCitaAdminDTO> listarCitasPendientes(int codigoMedico) throws Exception;
    int atenderCita(RegistroAtencionDTO registroAtencioDTO) throws Exception;
    List<ItemCitaDTO> listarHistorialAtencionPaciente(int codigoPaciente) throws Exception;
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;
    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico);
}
