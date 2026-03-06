package proyectoveterinaria;

import javax.swing.JOptionPane;

public class Registro {

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
