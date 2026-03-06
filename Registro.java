package registro;
import javax.swing.JOptionPane;
package proyectoveterinaria;
/**
 *
 * @author carlosroman
 */
public class Registro {

       
    private String tipoRegistro;
    private String descripcion;

    
    public Registro(String tipoRegistro, String descripcion) {
        this.tipoRegistro = tipoRegistro;
        this.descripcion = descripcion;
    }

   
    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    public static void menuRegistro() {

        int opcion = 0;

        while (opcion != 4) {

            String entrada = JOptionPane.showInputDialog(
                    "Registro\n"
                  + "1- Registrar un propietario\n"
                  + "2- Registrar una mascota\n"
                  + "3- Registrar un servicio\n"
                  + "4- Deolverse"
            );

            if (entrada == null) {
                opcion = 4;
            } else if (entrada.equals("1") || entrada.equals("2")
                    || entrada.equals("3") || entrada.equals("4")) {

                opcion = Integer.parseInt(entrada);

            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida");
                opcion = 0;
            }

            if (opcion == 1) {
                ProyectoVeterinaria.registrarPropietario();
            } else if (opcion == 2) {
                ProyectoVeterinaria.registrarMascota();
            } else if (opcion == 3) {
                ProyectoVeterinaria.registrarServicio();
            }
        }
    }

}
