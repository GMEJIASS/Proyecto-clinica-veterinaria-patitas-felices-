package proyectoveterinaria;

import javax.swing.JOptionPane;

public class Registro {

    public static void menuRegistro() {

        int opcion = 0;

        while (opcion != 4) {

            String entrada = JOptionPane.showInputDialog(
                    "REGISTRO\n\n"
                  + "1- Registrar veterinario\n"
                  + "2- Registrar servicio\n"
                  + "3- Registrar enfermedad\n"
                  + "4- Volver"
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
                Main.registrarVeterinario();
            } else if (opcion == 2) {
                Main.registrarServicio();
            } else if (opcion == 3) {
                Main.registrarEnfermedad();
            }
        }
    }
}
