package co.edu.uniquindio.proyecto.servicios;

public interface EmailServicio {

    void enviarCorreo(String mensaje, String para, String asunto, String de);

}
