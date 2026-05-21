package veterinaria;

import java.util.Scanner;

public class SistemaVeterinaria {

    private static Lista listaGeneral = new Lista();
    private static Cola colaPendientes = new Cola();
    private static Pila historialProcesados = new Pila();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    registrarMascota();
                    break;

                case 2:
                    verElementosRegistrados();
                    break;

                case 3:
                    verPendientes();
                    break;

                case 4:
                    procesarSiguiente();
                    break;

                case 5:
                    verHistorial();
                    break;

                case 6:
                    buscarPorCodigo();
                    break;

                case 7:
                    cancelarPendiente();
                    break;

                case 8:
                    deshacerProcesamiento();
                    break;

                case 9:
                    verCantidadElementos();
                    break;

                case 10:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 10);
    }

    public static void mostrarMenu() {

        System.out.println("\n===== SISTEMA VETERINARIA =====");
        System.out.println("1. Registrar elemento");
        System.out.println("2. Ver todos los elementos registrados");
        System.out.println("3. Ver elementos pendientes");
        System.out.println("4. Procesar siguiente elemento");
        System.out.println("5. Ver historial de elementos procesados");
        System.out.println("6. Buscar elemento por código");
        System.out.println("7. Cancelar elemento pendiente");
        System.out.println("8. Deshacer último procesamiento");
        System.out.println("9. Ver cantidad de elementos");
        System.out.println("10. Salir");
    }

    public static void registrarMascota() {

        System.out.println("\n=== REGISTRO DE MASCOTA ===");

        System.out.print("Código de atención: ");
        String codigo = sc.nextLine();

        MascotaAtencion mascotaBuscada =
                new MascotaAtencion(codigo, "", "", "", "", "");

        if (listaGeneral.contiene(mascotaBuscada)) {
            System.out.println("Ya existe una mascota con ese código");
            return;
        }

        System.out.print("Nombre de la mascota: ");
        String nombreMascota = sc.nextLine();

        System.out.print("Especie: ");
        String especie = sc.nextLine();

        System.out.print("Nombre del propietario: ");
        String propietario = sc.nextLine();

        System.out.print("Motivo de consulta: ");
        String motivo = sc.nextLine();

        MascotaAtencion mascota = new MascotaAtencion(
                codigo,
                nombreMascota,
                especie,
                propietario,
                motivo,
                "Pendiente"
        );

        listaGeneral.agregar(mascota);
        colaPendientes.encolar(mascota);

        System.out.println("Mascota registrada correctamente");
    }

    public static void verElementosRegistrados() {

        System.out.println("\n=== LISTA GENERAL ===");

        listaGeneral.mostrarAdelante();
    }

    public static void verPendientes() {

        System.out.println("\n=== COLA DE PENDIENTES ===");

        colaPendientes.mostrar();
    }

    public static void procesarSiguiente() {

        if (colaPendientes.esVacia()) {
            System.out.println("No hay elementos pendientes");
            return;
        }

        MascotaAtencion procesado =
                (MascotaAtencion) colaPendientes.desencolar();

        procesado.setEstado("Atendido");

        historialProcesados.apilar(procesado);

        System.out.println("Elemento procesado:");
        System.out.println(procesado);
    }

    public static void verHistorial() {

        System.out.println("\n=== HISTORIAL ===");

        historialProcesados.mostrar();
    }

    public static void buscarPorCodigo() {

        System.out.print("Ingrese el código: ");
        String codigo = sc.nextLine();

        MascotaAtencion mascotaBuscada =
                new MascotaAtencion(codigo, "", "", "", "", "");

        Object resultado = listaGeneral.buscarDato(mascotaBuscada);

        if (resultado == null) {
            System.out.println("No se encontró el elemento");
        } else {
            System.out.println(resultado);
        }
    }

    public static void cancelarPendiente() {

        if (colaPendientes.esVacia()) {
            System.out.println("No hay pendientes");
            return;
        }

        System.out.print("Ingrese el código a cancelar: ");
        String codigo = sc.nextLine();

        Cola colaAuxiliar = new Cola();

        boolean encontrado = false;

        while (!colaPendientes.esVacia()) {

            MascotaAtencion mascota =
                    (MascotaAtencion) colaPendientes.desencolar();

            if (mascota.getCodigoAtencion().equals(codigo)) {

                mascota.setEstado("Cancelado");

                encontrado = true;

            } else {

                colaAuxiliar.encolar(mascota);
            }
        }

        while (!colaAuxiliar.esVacia()) {
            colaPendientes.encolar(colaAuxiliar.desencolar());
        }

        if (encontrado) {
            System.out.println("Elemento cancelado correctamente");
        } else {
            System.out.println("Elemento no encontrado");
        }
    }

    public static void deshacerProcesamiento() {

        if (historialProcesados.esVacia()) {
            System.out.println("No hay elementos para deshacer");
            return;
        }

        MascotaAtencion ultimo =
                (MascotaAtencion) historialProcesados.desapilar();

        ultimo.setEstado("Pendiente");

        colaPendientes.encolar(ultimo);

        System.out.println("Procesamiento deshecho correctamente");
    }

    public static void verCantidadElementos() {

        System.out.println("Cantidad total de registros: "
                + listaGeneral.cuentaElementos());
    }

    public static int leerEntero(String mensaje) {

        int numero;

        while (true) {

            try {

                System.out.print(mensaje);

                numero = Integer.parseInt(sc.nextLine());

                return numero;

            } catch (NumberFormatException e) {

                System.out.println("Debe ingresar un número válido");
            }
        }
    }
}
