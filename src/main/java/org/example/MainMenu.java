package org.example;

import org.example.ejercicio2.MainProducto;
import org.example.ejercicio3.MainLibros;
import org.example.ejercicio4.MainEmpleados;
import org.example.modelo.MainAlumnos;

import java.awt.*;
import java.util.Scanner;

public class MainMenu {

    private static final Scanner scMainMenu = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = pedirOpcion();
            switch (opcion) {
                case 1 -> MainAlumnos.main(new String[0]);   // ejecuta tu main existente
                case 2 -> MainProducto.main(new String[0]);
                case 3 -> MainLibros.main(new String[0]);
                case 4 -> MainEmpleados.main(new String[0]);
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scMainMenu.close(); // cerramos el scanner
    }

    private static void mostrarMenu() {
        System.out.println("""
                ----------------------------------------
                📋  MENÚ PRINCIPAL - TP FUNCIONAL JAVA
                ----------------------------------------
                1. Ver reporte de Alumnos
                2. Ver reporte de Productos
                3. Ver reporte de Libros
                4. Ver reporte de Empleados
                0. Salir
                ----------------------------------------
                """);
    }

    private static int pedirOpcion() {
        System.out.print("Elegí una opción: ");
        try {
            return Integer.parseInt(scMainMenu.nextLine());
        } catch (NumberFormatException e) {
            return -1; // opción inválida
        }
    }
}