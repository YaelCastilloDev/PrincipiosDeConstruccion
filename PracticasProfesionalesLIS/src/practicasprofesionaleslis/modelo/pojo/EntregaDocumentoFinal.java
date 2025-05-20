package practicasprofesionaleslis.modelo.pojo;

import java.time.LocalDate;

public class EntregaDocumentoFinal {
    private int id;
    private LocalDate fechaInicio; // Se usa LocalDate en vez de Date porque LocalDate solo trabaja con fechas y Date trabaja con Fecha y tiempo
    private LocalDate fechaFin;
    private String tipoDocumentoFinal; 
    private int puntaje;

    public EntregaDocumentoFinal() {
    }

    public EntregaDocumentoFinal(int id,  LocalDate fechaInicio, 
                               LocalDate fechaFin, String tipoDocumentoFinal, int puntaje) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoDocumentoFinal = tipoDocumentoFinal;
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

    public String getTipoDocumentoFinal() {
        return tipoDocumentoFinal;
    }

    public void setTipoDocumentoFinal(String tipoDocumentoFinal) {
        this.tipoDocumentoFinal = tipoDocumentoFinal;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    @Override
    public String toString() {
        return tipoDocumentoFinal + " (" + fechaInicio + " a " + fechaFin + ")";
    }
}