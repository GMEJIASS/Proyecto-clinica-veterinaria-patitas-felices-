//Atributos
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
public void leerDatos(){
  nombre=JOptionPane.showInputDialog(null,"Digite el nombre del medico veterinario: ");
  especialidad=JOptionPane.showInputDialog(null,"Digite la especialidad del medico veterinario: ");
  telefono=JOptionPane.showInputDialog(null,"Digite el numero de telefono del medico veterinario: ");
  codVeterinario=JOptionPane.showInputDialog(null,"Digite el codigo del medico veterinario: ");
}

public void mostrarDatos(){
  JOptionPane.showMessageDialog(null, "nombre: "+ nombre +
    "\n especialidad: " + especialidad +
    "\n telefono: " + telefono +
    "\n codVeterinario: " + codVeterinario);
}


