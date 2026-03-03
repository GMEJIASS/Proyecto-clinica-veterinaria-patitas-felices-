package proyectoveterinaria;

public class Cita {

    Mascota mascota;
    Servicios servicio;
    String fecha;
    double costo;

    public Cita(Mascota mascota, Servicios servicio, String fecha, double costo) {
        this.mascota = mascota;
        this.servicio = servicio;
        this.fecha = fecha;
        this.costo = costo;
    }
}
