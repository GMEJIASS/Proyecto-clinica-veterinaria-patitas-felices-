import javax.swing.JOptionPane;

public class Main {

    static Veterinario[] veterinarios = new Veterinario[10];
    static Servicio[] servicios = new Servicio[10];
    static Enfermedad[] enfermedades = new Enfermedad[10];
    static Cita[] citas = new Cita[10];


    static int cantVeterinarios = 0;
    static int cantServicios = 0;
    static int cantEnfermedades = 0;
    static int cantCitas = 0;

    public static void main(String[] args) {

        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU PRINCIPAL\n\n"
                    + "1. Registrar veterinario\n"
                    + "2. Mostrar veterinarios\n"
                    + "3. Registrar servicio\n"
                    + "4. Mostrar servicios\n"
                    + "5. Registrar enfermedad\n"
                    + "6. Mostrar enfermedades\n"
                    + "7. Registrar cita\n"
                    + "8. Mostrar citas\n"
                    + "9. Salir"
            ));

            switch (opcion) {
                case 1:
                    registrarVeterinario();
                    break;
                case 2:
                    mostrarVeterinarios();
                    break;
                case 3:
                    registrarServicio();
                    break;
                case 4:
                    mostrarServicios();
                    break;
                case 5:
                    registrarEnfermedad();
                    break;
                case 6:
                    mostrarEnfermedades();
                    break;
                case 7:
                    registrarCita();
                    break;
                case 8:
                    mostrarCitas();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
            }

        } while (opcion != 9);
    }

    public static void registrarVeterinario() {
        if (cantVeterinarios < veterinarios.length) {

            Veterinario v = new Veterinario();

            v.setNombre(JOptionPane.showInputDialog("Digite el nombre del veterinario:"));
            v.setEspecialidad(JOptionPane.showInputDialog("Digite la especialidad:"));
            v.setTelefono(JOptionPane.showInputDialog("Digite el telefono:"));
            v.setCodVeterinario(JOptionPane.showInputDialog("Digite el codigo del veterinario:"));

            veterinarios[cantVeterinarios] = v;
            cantVeterinarios++;

            JOptionPane.showMessageDialog(null, "Veterinario registrado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo de veterinarios");
        }
    }

    public static void mostrarVeterinarios() {
        if (cantVeterinarios == 0) {
            JOptionPane.showMessageDialog(null, "No hay veterinarios registrados");
        } else {
            String s = "";

            for (int i = 0; i < cantVeterinarios; i++) {
                s = s + veterinarios[i].mostrarInformacion() + "\n\n";
            }

            JOptionPane.showMessageDialog(null, s);
        }
    }

    public static void registrarServicio() {
        if (cantServicios < servicios.length) {

            Servicio s = new Servicio();

            s.setNombre(JOptionPane.showInputDialog("Digite el nombre del servicio:"));
            s.setDescripcion(JOptionPane.showInputDialog("Digite la descripcion del servicio:"));
            s.setCosto(Double.parseDouble(JOptionPane.showInputDialog("Digite el costo del servicio:")));

            servicios[cantServicios] = s;
            cantServicios++;

            JOptionPane.showMessageDialog(null, "Servicio registrado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo de servicios");
        }
    }

    public static void mostrarServicios() {
        if (cantServicios == 0) {
            JOptionPane.showMessageDialog(null, "No hay servicios registrados");
        } else {
            String s = "";

            for (int i = 0; i < cantServicios; i++) {
                s = s + servicios[i].mostrarInformacion() + "\n\n";
            }

            JOptionPane.showMessageDialog(null, s);
        }
    }

    public static void registrarEnfermedad() {
        if (cantEnfermedades < enfermedades.length) {

            Enfermedad e = new Enfermedad();

            e.setNombre(JOptionPane.showInputDialog("Digite el nombre de la enfermedad:"));
            e.setDescripcion(JOptionPane.showInputDialog("Digite la descripcion de la enfermedad:"));
            e.setSintomas(JOptionPane.showInputDialog("Digite los sintomas:"));

            enfermedades[cantEnfermedades] = e;
            cantEnfermedades++;

            JOptionPane.showMessageDialog(null, "Enfermedad registrada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo de enfermedades");
        }
    }

    public static void mostrarEnfermedades() {
        if (cantEnfermedades == 0) {
            JOptionPane.showMessageDialog(null, "No hay enfermedades registradas");
        } else {
            String s = "";

            for (int i = 0; i < cantEnfermedades; i++) {
                s = s + enfermedades[i].mostrarInformacion() + "\n\n";
            }

            JOptionPane.showMessageDialog(null, s);
        }
    }

    public static void registrarCita() {

    if (cantCitas < citas.length && cantServicios > 0) {

        int indexServicio = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione el servicio:\n"));

        for (int i = 0; i < cantServicios; i++) {
            JOptionPane.showMessageDialog(null, i + " - " + servicios[i].getNombre());
        }

        if (indexServicio >= 0 && indexServicio < cantServicios) {

            String fecha = JOptionPane.showInputDialog("Digite la fecha:");

            Cita c = new Cita(
                    null, // no tienes mascota en este sistema
                    servicios[indexServicio],
                    fecha,
                    servicios[indexServicio].getCosto()
            );

            citas[cantCitas] = c;
            cantCitas++;

            JOptionPane.showMessageDialog(null, "Cita registrada correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "Selección inválida");
        }

    } else {
        JOptionPane.showMessageDialog(null, "No hay espacio o no hay servicios");
    }
}

    public static void mostrarCitas() {

    if (cantCitas == 0) {
        JOptionPane.showMessageDialog(null, "No hay citas registradas");
    } else {

        String s = "";

        for (int i = 0; i < cantCitas; i++) {

            s += "Cita #" + (i + 1) + "\n";
            s += "Servicio: " + citas[i].getServicio().getNombre() + "\n";
            s += "Fecha: " + citas[i].getFecha() + "\n";
            s += "Costo: ₡" + citas[i].getCosto() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, s);
    }
}
}
