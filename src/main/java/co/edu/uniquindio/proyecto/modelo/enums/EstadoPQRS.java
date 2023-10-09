package co.edu.uniquindio.proyecto.modelo.enums;

import jakarta.persistence.Id;

import javax.print.DocFlavor;

public enum EstadoPQRS {

    NUEVO("Nuevo"),
    ENPROCESO("En proceso"),
    RESUELTO("Resuelto"),
    ARCHIVADO("Archivado");

    private String nombre;

    EstadoPQRS(String nombre){ this.nombre = nombre;}
}
