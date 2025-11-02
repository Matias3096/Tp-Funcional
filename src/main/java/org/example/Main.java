package org.example;

import org.example.modelo.Alumno;
import org.example.modelo.GeneradorAlumnos;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 1 ");
        /*
        EJERCICIO 1
         */
        List<Alumno> alumnos = GeneradorAlumnos.generar(30);

        // Mostrar todos
        System.out.println("\n*******************************************" +
                "        \nLISTA DE ALUMNOS                         **"
                + "\n*******************************************");

        alumnos.forEach(System.out::println);

        // 1. Aprobados en mayúsculas y ordenados
        System.out.println("\nInciso 1: aprobados en mayusculas y ordenados");
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("**************************" +
                "\nAPROBADOS: " + aprobados
                + "\n*****************");

        // 2. Promedio general
        System.out.println("\nInciso 2: PROMEDIO GENERAL");
        double promedio = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);

        System.out.println("\nPromedio general: " + promedio + "\n");

        // 3. Agrupar por curso
        System.out.println("\nInciso 3:  AGRUPANDO POR CURSO");
        Map<String, List<Alumno>> porCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        porCurso.forEach((curso, lista) -> {
            System.out.println("\n=== Curso: " + curso + " ===" + "\n");
            lista.forEach(System.out::println);
        });

        // 4. Top 3 mejores alumnos
        List<String> top3 = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .map(Alumno::getNombre)
                .collect(Collectors.toList());
                System.out.println("\nTop 3: " + top3);



        //------------------------------------------EJERCICIO 2----------------------------------------------


    }
}