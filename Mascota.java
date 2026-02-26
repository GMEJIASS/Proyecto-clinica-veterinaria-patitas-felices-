package proyectoveterinaria;

public class Mascota {

    String nombre;
    String especie;
    int edad;
    Propietario propietario;

    public Mascota(String nombre, String especie, int edad, Propietario propietario) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.propietario = propietario;
    }
}

