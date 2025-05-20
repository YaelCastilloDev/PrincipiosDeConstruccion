package practicasprofesionaleslis.modelo.pojo;

import java.time.LocalDate;

public class EntregaDocumentoIntermedio {
    private int id;
    private LocalDate fechaInicio; // Se usa LocalDate en vez de Date porque LocalDate solo trabaja con fechas y Date trabaja con Fecha y tiempo
    private LocalDate fechaFin;
    private String tipoDocumentoIntermedio;
    private int puntaje;

    public EntregaDocumentoIntermedio() {
    }

    public EntregaDocumentoIntermedio(int id,  LocalDate fechaInicio, 
                                    LocalDate fechaFin, String tipoDocumentoIntermedio, int puntaje) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoDocumentoIntermedio = tipoDocumentoIntermedio;
        this.puntaje = puntaje;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoDocumentoIntermedio() {
        return tipoDocumentoIntermedio;
    }

    public void setTipoDocumentoIntermedio(String tipoDocumentoIntermedio) {
        this.tipoDocumentoIntermedio = tipoDocumentoIntermedio;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    @Override
    public String toString() {
        return tipoDocumentoIntermedio + " (" + fechaInicio + " a " + fechaFin + ")";
    }
}