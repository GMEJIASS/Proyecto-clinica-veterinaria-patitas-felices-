package veterinaria;
import javax.swing.JOptionPane;

public class Servicios {
//Atributos
private String nombreServicio;
private double costo;
private String descripcion;

//Constructor 
public Servicios(){
  this.nombreServicio="";
  this.costo=0.00;
  this.descripcion="";
}

//Getter & Setter
  public String getNombreServicio() {
    return nombreServicio;
  }
  public void setNombreServicio(String nombreServicio) {
    this.nombreServicio = nombreServicio;
  }
  public double getCosto() {
    return costo;
  }
  public void setCosto(double costo) {
    this.costo;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion ) {
    this.descripcion = descripcion;
}


}
