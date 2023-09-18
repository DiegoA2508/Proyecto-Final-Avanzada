package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.*;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medicoDTO) throws Exception;

    int actualizarMedico(int codigo, MedicoDTO medicoDTO) throws Exception;
    String eliminarMedico(int codigo) throws Exception;
    List<InfoMedicoAdminDTO> listarMedicos();
    DetalleMedicoDTO obtenerMedico(int codigo);
    List<PQRSAdminDTO> listarPQRS();
    String responderPQRS(RespuestaPQRSDTO respuesta) throws Exception;
    DetallePQRSDTO verDetallePQRS(int codigo);
    List<CitasAdminDTO> listarCitas();

}