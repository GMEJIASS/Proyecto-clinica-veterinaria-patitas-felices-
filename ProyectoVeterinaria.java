package proyectoveterinaria;

import javax.swing.JOptionPane;

public class ProyectoVeterinaria {

    static Propietario[] propietarios = new Propietario[10];
    static Mascota[] mascotas = new Mascota[10];

    static int contPropietarios = 0;
    static int contMascotas = 0;

    public static void main(String[] args) {

        propietarios[contPropietarios++] = new Propietario("Carlos");
        propietarios[contPropietarios++] = new Propietario("Ana");

        mascotas[contMascotas++] = new Mascota("Firulais", "Perro", 3, propietarios[0]);
        mascotas[contMascotas++] = new Mascota("Michi", "Gato", 2, propietarios[1]);

        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "CLÍNICA VETERINARIA\n\n"
                  + "1. Registro\n"
                  + "2. Ver mascotas registradas\n"
                  + "3. Registrar cita médica\n"
                  + "4. Registrar servicio realizado\n"
                  + "5. Salir\n\n"
                  + "Seleccione una opción:"
            ));

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Módulo Registro");
                    break;
                case 2:
                    menuVerMascotas();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Módulo Citas");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Módulo Servicios");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 5);
    }

    static void menuVerMascotas() {

        if (contMascotas == 0) {
            JOptionPane.showMessageDialog(null, "No hay mascotas registradas");
            return;
        }

        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "VER MASCOTAS\n\n"
                  + "1. Ver todas\n"
                  + "2. Filtrar por propietario\n"
                  + "3. Regresar"
            ));

            if (opcion == 1) {
                mostrarMascotas();
            } else if (opcion == 2) {
                filtrarMascotas();
            } else if (opcion != 3) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 3);
    }

    static void mostrarMascotas() {
        String texto = "";

        for (int i = 0; i < contMascotas; i++) {
            texto += "Mascota: " + mascotas[i].nombre + "\n";
            texto += "Propietario: " + mascotas[i].propietario.nombre + "\n";
            texto += "Especie: " + mascotas[i].especie + "\n";
            texto += "Edad: " + mascotas[i].edad + "\n\n";
        }

        JOptionPane.showMessageDialog(null, texto);
    }

    static void filtrarMascotas() {
        String nombre = JOptionPane.showInputDialog("Nombre del propietario:");
        String texto = "";
        boolean hay = false;

        for (int i = 0; i < contMascotas; i++) {
            if (mascotas[i].propietario.nombre.equalsIgnoreCase(nombre)) {
                texto += "Mascota: " + mascotas[i].nombre + "\n";
                texto += "Especie: " + mascotas[i].especie + "\n";
                texto += "Edad: " + mascotas[i].edad + "\n\n";
                hay = true;
            }
        }

        if (hay) {
            JOptionPane.showMessageDialog(null, texto);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron mascotas");
        }
    }
}
