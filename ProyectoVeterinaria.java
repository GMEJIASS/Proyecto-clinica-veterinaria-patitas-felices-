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
                menuRegistro();

            } else if (opcion == 2) {
                menuVerMascotas();

            } else if (opcion == 3) {
                registrarCita();

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
    static void registrarPropietario() {

    if (contPropietarios >= propietarios.length) {
        JOptionPane.showMessageDialog(null, "No hay espacio");
        return;
    }

    String nombre = JOptionPane.showInputDialog("Nombre del propietario:");

    if (nombre == null || nombre.equals("")) {
        return;
    }

    propietarios[contPropietarios++] = new Propietario(nombre);

    JOptionPane.showMessageDialog(null, "Propietario registrado con éxito");
}
    static void registrarMascota() {

    if (contMascotas >= mascotas.length) {
        JOptionPane.showMessageDialog(null, "No hay espacio");
        return;
    }

    if (contPropietarios == 0) {
        JOptionPane.showMessageDialog(null, "Primero debe registrar un propietario");
        return;
    }

    String nombre = JOptionPane.showInputDialog("Nombre de la mascota:");
    String especie = JOptionPane.showInputDialog("Especie:");
    String edadTexto = JOptionPane.showInputDialog("Edad:");

    if (nombre == null || especie == null || edadTexto == null) {
        return;
    }

    int edad = Integer.parseInt(edadTexto);

    String lista = "";
    for (int i = 0; i < contPropietarios; i++) {
        lista += i + " - " + propietarios[i].nombre + "\n";
    }

    String seleccion = JOptionPane.showInputDialog(
            "Seleccione propietario:\n" + lista);

    if (seleccion == null) {
        return;
    }

    int indice = Integer.parseInt(seleccion);

    if (indice >= 0 && indice < contPropietarios) {

        mascotas[contMascotas++] =
                new Mascota(nombre, especie, edad, propietarios[indice]);

        JOptionPane.showMessageDialog(null, "Mascota registrada con éxito");

    } else {
        JOptionPane.showMessageDialog(null, "Selección inválida");
    }
}
    static void registrarServicio() {

    if (contServicios >= servicios.length) {
        JOptionPane.showMessageDialog(null, "No hay espacio");
        return;
    }

    Servicios nuevo = new Servicios();

    String nombre = JOptionPane.showInputDialog("Nombre del servicio:");
    String descripcion = JOptionPane.showInputDialog("Descripción:");
    String costoTexto = JOptionPane.showInputDialog("Costo:");

    if (nombre == null || descripcion == null || costoTexto == null) {
        return;
    }

    double costo = Double.parseDouble(costoTexto);

    nuevo.setNombreServicio(nombre);
    nuevo.setDescripcion(descripcion);
    nuevo.setCosto(costo);

    servicios[contServicios++] = nuevo;

    JOptionPane.showMessageDialog(null, "Servicio registrado con éxito");
}
    

    static void registrarCita() {

    if (contMascotas == 0) {
        JOptionPane.showMessageDialog(null, "No hay mascotas registradas");
        return;
    }

    if (contServicios == 0) {
        JOptionPane.showMessageDialog(null, "No hay servicios registrados");
        return;
    }

    if (contCitas >= citas.length) {
        JOptionPane.showMessageDialog(null, "No hay espacio");
        return;
    }

    String listaMascotas = "";
    for (int i = 0; i < contMascotas; i++) {
        listaMascotas += i + " - " + mascotas[i].nombre + "\n";
    }

    String seleccionMascota = JOptionPane.showInputDialog(
            "Seleccione mascota:\n" + listaMascotas);

    if (seleccionMascota == null) {
        return;
    }

    int indiceMascota = Integer.parseInt(seleccionMascota);

    if (indiceMascota < 0 || indiceMascota >= contMascotas) {
        JOptionPane.showMessageDialog(null, "Selección inválida");
        return;
    }

    String listaServicios = "";
    for (int i = 0; i < contServicios; i++) {
        listaServicios += i + " - " + servicios[i].getNombreServicio() + "\n";
    }

    String seleccionServicio = JOptionPane.showInputDialog(
            "Seleccione servicio:\n" + listaServicios);

    if (seleccionServicio == null) {
        return;
    }

    int indiceServicio = Integer.parseInt(seleccionServicio);

    if (indiceServicio < 0 || indiceServicio >= contServicios) {
        JOptionPane.showMessageDialog(null, "Selección inválida");
        return;
    }

    String fecha = JOptionPane.showInputDialog("Ingrese fecha:");
    if (fecha == null || fecha.equals("")) {
        return;
    }

    Cita nueva = new Cita(
            mascotas[indiceMascota],
            servicios[indiceServicio],
            fecha,
            servicios[indiceServicio].getCosto()
    );

    citas[contCitas++] = nueva;

    JOptionPane.showMessageDialog(null,
            "CITA REGISTRADA\n\n"
          + "Mascota: " + mascotas[indiceMascota].nombre + "\n"
          + "Servicio: " + servicios[indiceServicio].getNombreServicio() + "\n"
          + "Fecha: " + fecha + "\n"
          + "Costo: ₡" + servicios[indiceServicio].getCosto());
}
}
