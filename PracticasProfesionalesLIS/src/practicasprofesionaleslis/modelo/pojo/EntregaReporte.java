package practicasprofesionaleslis.modelo.pojo;

import java.time.LocalDate;

public class EntregaReporte {
    private int idEntregaReporte;
    private LocalDate fechaInicio; // Se usa LocalDate en vez de Date porque LocalDate solo trabaja con fechas y Date trabaja con Fecha y tiempo
    private LocalDate fechaFin;
    private int numeroReporte;
    private int puntaje;

    public EntregaReporte() {
    }

    public EntregaReporte(int idEntregaReporte, LocalDate fechaInicio, 
                        LocalDate fechaFin, int numeroReporte, int puntaje) {
        this.idEntregaReporte = idEntregaReporte;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroReporte = numeroReporte;
        this.puntaje = puntaje;
    }

    // Getters y Setters
    public int getIdEntregaReporte() {
        return idEntregaReporte;
    }

    public void setIdEntregaReporte(int idEntregaReporte) {
        this.idEntregaReporte = idEntregaReporte;
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

    public int getNumeroReporte() {
        return numeroReporte;
    }

    public void setNumeroReporte(int numeroReporte) {
        this.numeroReporte = numeroReporte;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    @Override
    public String toString() {
        return "Reporte #" + numeroReporte + " (" + fechaInicio + " a " + fechaFin + ")";
    }
}