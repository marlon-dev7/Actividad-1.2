import java.util.Scanner;

// Clase principal que maneja el menú y la lógica de deshacer y rehacer.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pilas para manejar acciones
        Pila acciones = new Pila(100);      // acciones realizadas
        Pila deshechas = new Pila(100);     // acciones deshechas

        String textoActual = "";

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    // Guardamos el estado actual antes de modificarlo
                    acciones.push(textoActual);

                    System.out.print("Ingrese texto: ");
                    String nuevoTexto = scanner.nextLine();

                    textoActual += nuevoTexto;

                    // Si se escribe algo nuevo se eliminan los rehacer anteriores
                    deshechas.clear();

                    break;

                case 2:
                    // Deshacer acción
                    if (!acciones.isEmpty()) {

                        deshechas.push(textoActual);
                        textoActual = acciones.pop();

                        System.out.println("Acción deshecha.");

                    } else {
                        System.out.println("No hay acciones para deshacer.");
                    }

                    break;

                case 3:
                    // Rehacer acción
                    if (!deshechas.isEmpty()) {

                        acciones.push(textoActual);
                        textoActual = deshechas.pop();

                        System.out.println("Acción rehecha.");

                    } else {
                        System.out.println("No hay acciones para rehacer.");
                    }

                    break;

                case 4:
                    // Mostrar texto actual
                    System.out.println("Texto actual:");
                    System.out.println(textoActual);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
