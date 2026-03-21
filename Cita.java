package proyectoveterinaria;

public class Cita {

    private Mascota mascota;
    private Servicios servicio;
    private String fecha;
    private double costo;

    
    public Cita(Mascota mascota, Servicios servicio, String fecha, double costo) {
        this.mascota = mascota;
        this.servicio = servicio;
        this.fecha = fecha;
        this.costo = costo;
    }

   
    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
