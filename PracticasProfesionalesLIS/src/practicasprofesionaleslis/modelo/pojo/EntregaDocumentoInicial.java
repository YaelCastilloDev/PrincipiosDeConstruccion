package practicasprofesionaleslis.modelo.pojo;

import java.time.LocalDate;
import java.util.Date;

public class EntregaDocumentoInicial {
    private int id;
    private LocalDate fechaInicio; // Se usa LocalDate en vez de Date porque LocalDate solo trabaja con fechas y Date trabaja con Fecha y tiempo
    private LocalDate fechaFin;
    private String tipoDocumentoInicial;
    private int puntaje;

    public EntregaDocumentoInicial() {
    }

    public EntregaDocumentoInicial(int id, LocalDate fechaInicio, 
                                 LocalDate fechaFin, String tipoDocumentoInicial, int puntaje) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoDocumentoInicial = tipoDocumentoInicial;
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

    public String getTipoDocumentoInicial() {
        return tipoDocumentoInicial;
    }

    public void setTipoDocumentoInicial(String tipoDocumentoInicial) {
        this.tipoDocumentoInicial = tipoDocumentoInicial;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    @Override
    public String toString() {
        return tipoDocumentoInicial + " (" + fechaInicio + " a " + fechaFin + ")";
    }
}