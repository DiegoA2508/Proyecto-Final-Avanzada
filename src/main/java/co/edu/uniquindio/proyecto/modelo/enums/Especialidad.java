package co.edu.uniquindio.proyecto.modelo.enums;

import jakarta.persistence.Id;

public enum Especialidad {

    CARDIOLOGIA( "Armenia"),
    PEDIATRIA("Pereira"),
    OTORRINOLARINGOLOGIA("Calarca");

    private String nombre;

    Especialidad(String nombre){ this.nombre = nombre;}

}
