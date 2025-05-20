package practicasprofesionaleslis.modelo.pojo;

public class ExperienciaEducativa {
    private int id;
    private int nrc;
    private String nombre;
    private int creditos;
    private int numeroHoras;
    private String bloque;
    private String seccion;

    public ExperienciaEducativa() {
    }

    public ExperienciaEducativa(int id, int nrc, String nombre, int creditos, 
                               int numeroHoras, String bloque, String seccion) {
        this.id = id;
        this.nrc = nrc;
        this.nombre = nombre;
        this.creditos = creditos;
        this.numeroHoras = numeroHoras;
        this.bloque = bloque;
        this.seccion = seccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return nombre + " (NRC: " + nrc + ")";
    }
}