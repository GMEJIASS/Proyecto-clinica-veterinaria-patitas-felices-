package proyectoveterinaria;

import javax.swing.JOptionPane;

public class ProyectoVeterinaria {

    static Propietario[] propietarios = new Propietario[10];
    static Mascota[] mascotas = new Mascota[10];

    static int contPropietarios = 0;
    static int contMascotas = 0;
    static Servicios[] servicios = new Servicios[10];
    static Cita[] citas = new Cita[10];

    static int contServicios = 0;
    static int contCitas = 0;

    public static void main(String[] args) {

        // Datos de prueba
        propietarios[contPropietarios++] = new Propietario("Carlos");
        propietarios[contPropietarios++] = new Propietario("Ana");

        mascotas[contMascotas++] = new Mascota("Firulais", "Perro", 3, propietarios[0]);
        mascotas[contMascotas++] = new Mascota("Michi", "Gato", 2, propietarios[1]);

        int opcion = 0;

        while (opcion != 5) {

            String entrada = JOptionPane.showInputDialog(
                    "CLÍNICA VETERINARIA\n\n"
                  + "1. Registro\n"
                  + "2. Ver mascotas registradas\n"
                  + "3. Registrar cita médica\n"
                  + "4. Registrar servicio realizado\n"
                  + "5. Salir\n\n"
                  + "Seleccione una opción:"
            );

            if (entrada == null) {
                opcion = 5; // Cancelar = salir
            } else if (entrada.equals("1") || entrada.equals("2") ||
                       entrada.equals("3") || entrada.equals("4") ||
                       entrada.equals("5")) {

                opcion = Integer.parseInt(entrada);

            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida");
                opcion = 0;
            }

            if (opcion == 1) {
                JOptionPane.showMessageDialog(null, "Módulo Registro");

            } else if (opcion == 2) {
                menuVerMascotas();

            } else if (opcion == 3) {
                JOptionPane.showMessageDialog(null, "Módulo Citas");

            } else if (opcion == 4) {
                JOptionPane.showMessageDialog(null, "Módulo Servicios");

            } else if (opcion == 5) {
                JOptionPane.showMessageDialog(null, "Saliendo...");
            }
        }
    }

    static void menuVerMascotas() {

        if (contMascotas == 0) {
            JOptionPane.showMessageDialog(null, "No hay mascotas registradas");
            return;
        }

        int opcion = 0;

        while (opcion != 3) {

            String entrada = JOptionPane.showInputDialog(
                    "VER MASCOTAS\n\n"
                  + "1. Ver todas\n"
                  + "2. Filtrar por propietario\n"
                  + "3. Regresar"
            );

            if (entrada == null) {
                opcion = 3; // Cancelar = regresar
            } else if (entrada.equals("1") ||
                       entrada.equals("2") ||
                       entrada.equals("3")) {

                opcion = Integer.parseInt(entrada);

            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida");
                opcion = 0;
            }

            if (opcion == 1) {
                mostrarMascotas();

            } else if (opcion == 2) {
                filtrarMascotas();
            }
        }
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

        if (nombre == null || nombre.equals("")) {
            return;
        }

        String texto = "";
        boolean encontrado = false;

        for (int i = 0; i < contMascotas; i++) {

            if (mascotas[i].propietario.nombre.equalsIgnoreCase(nombre)) {

                texto += "Mascota: " + mascotas[i].nombre + "\n";
                texto += "Especie: " + mascotas[i].especie + "\n";
                texto += "Edad: " + mascotas[i].edad + "\n\n";

                encontrado = true;
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, texto);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron mascotas");
        }
    }
}
