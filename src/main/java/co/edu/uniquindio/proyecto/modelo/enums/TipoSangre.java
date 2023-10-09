package co.edu.uniquindio.proyecto.modelo.enums;

import jakarta.persistence.Id;

public enum TipoSangre {

    APOSITIVA("A+"),
    ANEGATIVA("A-"),
    BPOSITIVA("B+"),
    BNEGATIVA("B-"),
    ABPOSITIVA("AB+"),
    ABNEGATIVA("AB-"),
    OPOSITIVA("O+"),
    ONEGATIVA("O-");

    private String nombre;

    TipoSangre(String nombre) { this.nombre=nombre;}
}
