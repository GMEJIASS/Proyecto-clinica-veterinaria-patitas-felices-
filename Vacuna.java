package proyectoveterinaria;

public class Vacuna {

    private String nombreVacuna;
    private String descripcion;
    private double costo;

    // Constructor
    public Vacuna(String nombreVacuna, String descripcion, double costo) {
        this.nombreVacuna = nombreVacuna;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    // Getters y Setters
    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}

