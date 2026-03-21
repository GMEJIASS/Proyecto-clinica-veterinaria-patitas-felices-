import javax.swing.JOptionPane;

public class Main {

    static Veterinario[] veterinarios = new Veterinario[10];
    static Servicio[] servicios = new Servicio[10];
    static Enfermedad[] enfermedades = new Enfermedad[10];
    static Cita[] citas = new Cita[10];
    static Vacuna[] vacunas = new Vacuna[10];

    
    static int cantVeterinarios = 0;
    static int cantServicios = 0;
    static int cantEnfermedades = 0;
    static int cantCitas = 0;
    static int cantVacunas = 0;

    public static void main(String[] args) {

        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU PRINCIPAL\n\n"
                    + "1. Ir a modulo Registro\n"
                    + "2. Registrar veterinario\n"
                    + "3. Mostrar veterinarios\n"
                    + "4. Registrar servicio\n"
                    + "5. Mostrar servicios\n"
                    + "6. Registrar enfermedad\n"
                    + "7. Mostrar enfermedades\n"
                    + "8. Registrar cita\n"
                    + "9. Mostrar citas\n"
                    + "10. Registrar vacuna\n"
                    + "11. Mostrar vacunas\n"
                    + "12. Salir"
                   
            ));

            switch (opcion) {
               case 1:
                   Registro.menuRegistro();
                   break;
                case 2:
                    registrarVeterinario();
                    break;
                case 3:
                    mostrarVeterinarios();
                    break;
                case 4:
                    registrarServicio();
                    break;
                case 5:
                    mostrarServicios();
                    break;
                case 6:
                    registrarEnfermedad();
                    break;
                case 7:
                    mostrarEnfermedades();
                    break;
                case 8:
                    registrarCita();
                    break;
                case 9:
                    mostrarCitas();
                    break;
                case 10:
                    registrarVacuna();
                    break;
                case 11:
                    mostrarVacunas();
                    break;
                case 12:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
            }

        } while (opcion != 12);
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

    public static void registrarVacuna() {

    if (cantVacunas < vacunas.length) {

        String nombre = JOptionPane.showInputDialog("Digite el nombre de la vacuna:");
        String descripcion = JOptionPane.showInputDialog("Digite la descripción:");
        double costo = Double.parseDouble(JOptionPane.showInputDialog("Digite el costo:"));

        Vacuna v = new Vacuna(nombre, descripcion, costo);

        vacunas[cantVacunas] = v;
        cantVacunas++;

        JOptionPane.showMessageDialog(null, "Vacuna registrada correctamente");

    } else {
        JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo de vacunas");
    }
}

    public static void mostrarVacunas() {

    if (cantVacunas == 0) {
        JOptionPane.showMessageDialog(null, "No hay vacunas registradas");
    } else {

        String s = "";

        for (int i = 0; i < cantVacunas; i++) {
            s += "Nombre: " + vacunas[i].getNombreVacuna() + "\n";
            s += "Descripción: " + vacunas[i].getDescripcion() + "\n";
            s += "Costo: ₡" + vacunas[i].getCosto() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, s);
    }
}
}
