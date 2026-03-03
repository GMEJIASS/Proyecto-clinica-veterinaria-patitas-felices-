package veterinaria;

public class Enfermedades{
  private String nombre;
  private String sintomas;
  private String descripcion;
  private double signosVitales;

  public Enfermedades(){
    this.nombre="";
    this.sintomas="";
    this.descripcion="";
    this.signosVitales=0.00;
  }
  public String getNombre(){
    return nombre;
  }
  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public String getSintomas() {
    return sintomas; 
  }
  public void setSintomas(String sintomas){
    this.sintomas= sintomas;
  }
  public String getDescripcion(){
    return descripcion;
  }
  public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
  }
  public double getSignosVitales(){
    return signosVitales;
  }
  public void setSignosVitales(double signosVitales){
    this.signosVitales = signosVitales;
  }
}
