package co.edu.uniquindio.proyecto.servicios.implementaciones;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.dto.admin.*;
import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.modelo.enums.Estado;
import co.edu.uniquindio.proyecto.modelo.enums.EstadoPQRS;
import co.edu.uniquindio.proyecto.repositorios.*;
import co.edu.uniquindio.proyecto.servicios.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepository medicoRepository;
    private final PQRSRepo pqrsRepo;
    private final CuentaRepo cuentaRepo;
    private final MensajeRepo mensajeRepo;
    private final HorarioRepo horarioRepo;
    private final CitaRepo citaRepo;
    private final MedicoRepo medicoRepo;
    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        if( estaRepetidoCorreo(medicoDTO.correo()) ){
            throw new Exception("El correo ya está en uso");
        }
        if( estaRepetidoCedula( medicoDTO.cedula()) ){
            throw new Exception("La cédula ya está en uso");
        }

        Medico medico = new Medico();
        medico.setCedula(medicoDTO.cedula() );
        medico.setTelefono(medicoDTO.telefono());
        medico.setNombre(medicoDTO.nombre() );
        medico.setEspecialidad( medicoDTO.especialidad() );
        medico.setCiudad(medicoDTO.ciudad());
        medico.setCorreo(medicoDTO.correo() );
        medico.setPassword(medicoDTO.password());
        medico.setUrlFoto(medicoDTO.urlFoto());
        medico.setEstado(Estado.ACTIVO);

        Medico medicoNuevo = medicoRepo.save(medico);

        asignarHorariosMedico( medicoNuevo, medicoDTO.horarios() );

        return medicoNuevo.getCodigo();
    }

    private void asignarHorariosMedico(Medico medicoNuevo, List<HorarioDTO> horarios){

        for (HorarioDTO h: horarios) {
            Horario hm = new Horario();
            hm.setDia(h.dia());
            hm.setHoraInicio(LocalTime.from(h.horaInicio()));
            hm.setHoraFin(LocalTime.from(h.horaFin()));
            hm.setCodigoMedico(medicoNuevo);

            horarioRepo.save(hm);
        }
    }

    private boolean estaRepetidoCorreo(String correo) {

        return medicoRepository.buscarPorCorreo(correo) !=null;
    }
    private boolean estaRepetidoCedula(String cedula) {

        return medicoRepository.buscarPorCedula(cedula) != null;
    }


    @Override
    public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {

        Optional<Medico> opcional =medicoRepo.findById(Integer.valueOf(medicoDTO.cedula()));

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+medicoDTO.cedula());
        }

        Medico buscado = opcional.get();

        buscado.setCedula(medicoDTO.cedula() );
        buscado.setTelefono(medicoDTO.telefono());
        buscado.setNombre(medicoDTO.nombre() );
        buscado.setEspecialidad(medicoDTO.especialidad());
        buscado.setCiudad(medicoDTO.ciudad());
        buscado.setCorreo(medicoDTO.correo() );
        buscado.setUrlFoto(medicoDTO.urlFoto());

        medicoRepo.save( buscado );

        return buscado.getCodigo();
    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {
        Optional<Medico> opcional =medicoRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigo);
        }

        Medico buscado = opcional.get();
        buscado.setEstado(Estado.INACTIVO);
        medicoRepo.save( buscado );
    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {
        List<Medico> medicos = medicoRepo.findAll();

        if(medicos.isEmpty()){
            throw new Exception("No hay médicos registrados");
        }

        List<ItemMedicoDTO> respuesta = new ArrayList<>();

        for(Medico m: medicos){
            respuesta.add( new ItemMedicoDTO(
                    m.getCedula(),
                    m.getNombre(),
                    m.getUrlFoto(),
                    m.getEspecialidad()) );
        }

        /*List<ItemMedicoDTO> respuesta = medicos.stream().map( m -> new ItemMedicoDTO(
                m.getCodigo(),
                m.getCedula(),
                m.getNombre(),
                m.getUrlFoto(),
                m.getEspecialidad()
        ) ).toList();*/

        return respuesta;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {
        Optional<Medico> opcional =medicoRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigo);
        }

        Medico buscado = opcional.get();

        return new DetalleMedicoDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getCiudad(),
                buscado.getEspecialidad(),
                buscado.getTelefono(),
                buscado.getCorreo(),
                buscado.getUrlFoto(),
                new ArrayList<>()
        );
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {
        List<PQRS> listaPqrs = pqrsRepo.findAll();
        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for( PQRS p: listaPqrs ){

            respuesta.add( new ItemPQRSDTO(
                    p.getEstadoPQRS(),
                    p.getMotivo(),
                    p.getCodigo(),
                    p.getFechaCreacion(),
                    p.getCodigoCita().getCodigoPaciente().getNombre()
            ) );

        }

        return respuesta;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        Optional<PQRS> opcionalPQRS = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());

        if(opcionalPQRS.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+registroRespuestaDTO.codigoPQRS());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());

        if(opcionalCuenta.isEmpty()){
            throw new Exception("No existe una cuenta con el código "+registroRespuestaDTO.codigoCuenta());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setCodigoPQRS(opcionalPQRS.get());
        mensajeNuevo.setFechaCreacion( LocalDateTime.now() );
        mensajeNuevo.setCodigoCuenta(opcionalCuenta.get());
        mensajeNuevo.setMensaje(registroRespuestaDTO.mensaje() );

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        Optional<PQRS> opcional = pqrsRepo.findById(codigo);

        if(opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+codigo);
        }

        PQRS buscado = opcional.get();

        return new DetallePQRSDTO(
                buscado.getCodigo(),
                buscado.getEstadoPQRS(),
                buscado.getMotivo(),
                buscado.getCodigoCita().getCodigoPaciente().getNombre(),
                buscado.getCodigoCita().getCodigoMedico().getNombre(),
                buscado.getCodigoCita().getCodigoMedico().getEspecialidad(),
                buscado.getFechaCreacion(),
                new ArrayList<>()
        );
    }

    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception{
        Optional<PQRS> opcional = pqrsRepo.findById(codigoPQRS);
        if(opcional.isEmpty()){
            throw  new Exception("No existe un PQRS con el código " +codigoPQRS);
        }
        PQRS pqrs = opcional.get();
        pqrs.setEstadoPQRS(estadoPQRS);

        pqrsRepo.save(pqrs);
    }

    @Override
    public List<ItemCitaAdminDTO> listarCitas() throws Exception {

        List<Cita> citas = citaRepo.findAll();
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas listadas");
        }
        for (Cita c: citas) {
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
        return respuesta;
    }
}
