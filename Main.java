package estacionEspecial;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Scanner sl = new Scanner(System.in);
    private static EstacionEspacial e1 = new EstacionEspacial();
    private static Modulo modulo;
    private static Persona persona;

    public static void main(String[] args) {

        e1.agregarModulo(new Modulo("Laboratorio", 20, "Laboratorio"));
        e1.agregarModulo(new Modulo("Habitación", 20, "Habitación"));
        e1.agregarModulo(new Modulo("Comedor", 20, "Comedor"));
        int opcion = 0;
        do {
            menu();
            try {
                opcion = sc.nextInt();
                switchMain(opcion);
            } catch (InputMismatchException e) {
                System.out.println("!!\u26A0  Entrada invalida \u26A0!!");
                sc.next(); // Clear the invalid input
            }
        } while (opcion != 6);
        System.out.println("Gracias por usar nuestro programa!!");
    }

    private static void switchMain(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("******* Agregar Modulo **********");
                agregarModuloCase1();
                break;
            case 2:
                System.out.println("******* Eliminar modulo **********");
                eliminarModuloCase2();
                break;
            case 3:
                System.out.println("******* Agregar habitantes **********");
                agregarHabitantesCase3();
                break;
            case 4:
                System.out.println("******* eliminar habitantes **********");
                eliminarhabitantesCase2();
                break;
            case 5:
                System.out.println("******* Consultar Estacion Espacial **********");
                ConsultarEstacion();
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Entrada invalido (Ingresa un númeor entre (1-6)");
                break;
        }
    }

    private static void ConsultarEstacion() {
        for (int i = 0; i < e1.getModulo().length; i++) {
            if (e1.getModulo()[i] != null) {
                e1.getModulo()[i].listarHabitantes(); // List inhabitants of the module
                System.out.printf("Numero Total de Habitantes es %d \n", e1.numeroTotalHabitantes()); // Total inhabitants
            }
        }
    }

    private static void eliminarhabitantesCase2() {
        System.out.println("Introduce un nombre del habitantes: ");
        String nombre = sl.nextLine();
        boolean flag = false;
        for (int i = 0; i < e1.getModulo().length; i++) {
            if (e1.getModulo()[i] != null) {
                if (e1.getModulo()[i].eliminarHabitantes(nombre)) {
                    System.out.println("Habitante Eliminado Correctamente");
                } else {
                    System.out.println("!! No hay ningun habitante con este nombre !!");
                }
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No hay ningun modulo para eliminar habitantes");
        }
    }

    private static void agregarHabitantesCase3() {
        System.out.println("Introduce en qué módulo quieres agregar: ");
        String nombreModulo = sl.nextLine();
        boolean flag = false;
        for (int i = 0; i < e1.getModulo().length; i++) {
            if (e1.getModulo()[i] != null && e1.getModulo()[i].getNombre().equalsIgnoreCase(nombreModulo)) {
                System.out.println("Introduce un nombre para el habitante:");
                String nombre = sl.nextLine();
                persona = new Persona(nombre);
                if (e1.getModulo()[i].agregarHabitantes(persona)) {
                    System.out.println("Habitante agregado correctamente");
                } else {
                    System.out.println("No hay espacio para agregar habitantes");
                }
                flag = true;
                i=e1.getModulo().length; // Exit the loop after processing the module
            }
        }
        if (!flag) {
            System.out.println("!! No hay ningún módulo con este nombre !!");
        }
    }

    private static void eliminarModuloCase2() {
        System.out.println("Introduce un nombre para el módulo:");
        String nombre = sl.nextLine();
        if (e1.eliminarModulo(nombre)) {
            System.out.println("Módulo eliminado correctamente!!");
        } else {
            System.out.println("Hubo un problema al eliminar un módulo!!");
        }
    }

    private static void agregarModuloCase1() {
        System.out.println("Introduce un nombre para el módulo:");
        String nombre = sl.nextLine();
        System.out.println("Introduce la capacidad del módulo:");
        int capacidad = sc.nextInt();
        sc.nextLine(); // Clear the buffer after nextInt()
        System.out.println("Introduce el tipo del módulo (Laboratorio, Habitación, Comedor):");
        String tipo = sl.nextLine();
        modulo = new Modulo(nombre, capacidad, tipo);
        if (e1.agregarModulo(modulo)) {
            System.out.println("Módulo agregado correctamente!!");
        } else {
            System.out.println("Hubo un problema al agregar un módulo!!");
        }
    }

    private static void menu() {
        System.out.println("::::::::: Menú Principal :::::::::::");
        System.out.println("1. Agregar Módulo");
        System.out.println("2. Eliminar Módulo");
        System.out.println("3. Agregar habitantes");
        System.out.println("4. Eliminar habitantes");
        System.out.println("5. Consultar Información");
        System.out.println("6. Salir");
        System.out.print(">>>>>>>>>>>>");
    }
}
