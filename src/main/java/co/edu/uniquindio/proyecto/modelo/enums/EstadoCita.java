package co.edu.uniquindio.proyecto.modelo.enums;

import jakarta.persistence.Id;

public enum EstadoCita {

    PENDIENTE( "Pendiente"),
    ATENDIDA("Atendida");
    private String nombre;
    EstadoCita(String nombre){ this.nombre = nombre;}
}
