package veteriaria;
import javax.swing.JOptionPane;

public class Veterinario {
private String nombre;
private String especialidad;
private String telefono;
private String codVeterinario;

// Metodo constructor
public veterinario(){
  this.nombre="";
  this.especialidad="";
  this.telefono="";
  this.codVeterinario="";
}

// Metodos 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodVeterinario() {
        return codVeterinario;
    }
}

    public void setCodVeterinario(String codVeterinario) {
        this.codVeterinario = codVeterinario;
    }



