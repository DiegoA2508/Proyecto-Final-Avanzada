package co.edu.uniquindio.proyecto.servicios;

import ch.qos.logback.core.encoder.EchoEncoder;

public interface MedicoServicio {

    List<CitaMedicoDTO> listarCitasPendientes(int codigo) throws Exception;
    void atenderCita(AtencionMedicaDTO) throws Exception;

    List<CitaMedicoDTO> listarCitasPaciente(int codigoPaciente) throws Exception;
    void agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;
    List<CitaMedicoDTO> listarCitasRealizadasMedico();
}
