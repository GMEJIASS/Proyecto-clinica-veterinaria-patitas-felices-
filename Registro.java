static void menuRegistro() {

    int opcion = 0;

    while (opcion != 4) {

        String entrada = JOptionPane.showInputDialog(
                "REGISTRO\n\n"
              + "1. Registrar propietario\n"
              + "2. Registrar mascota\n"
              + "3. Registrar servicio\n"
              + "4. Regresar"
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
            registrarPropietario();
        } else if (opcion == 2) {
            registrarMascota();
        } else if (opcion == 3) {
            registrarServicio();
        }
    }
}
