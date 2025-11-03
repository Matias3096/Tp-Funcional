package org.example.ejercicio4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainEmpleados {
    public static void main(String[] args) {

        //Generar empleados
        List<Empleado> empleados = generadorEmpleados.generarEmpleados(30);

        //Lista completa

        System.out.println("\n **** LISTA COMPLETA DE EMPLEADOS ****");
        empleados.forEach( emp ->
                System.out.println( " * Nombre: " + emp.getNombre() + "  " + emp.getApellido() + "  Edad: " + emp.getEdad()
                + " | Departamento: " + emp.getDepartamento() + " | Salario: " + emp.getSalario() ));

        //Empleados con salario mayor a 2000, ordenados por salario de (mayor a menor)

        List<Empleado> bienPagados = empleados.stream()
                .filter( e -> e.getSalario() > 2500)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(Collectors.toList());

        System.out.println("\n **** EMPLEADOS CON SALARIO MAYOR A $2000 ****");
        if (bienPagados.isEmpty()) {
            System.out.println("No se encontro el empleado con salario mayor a 2000");
        } else {
            bienPagados.forEach( e1 -> System.out.println(" * " + e1.getNombre() + "  "
                    + e1.getApellido() + " Salario ->  " + e1.getSalario()) );
        }

        // PROMEDIO GENERAL
        double promedio = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);
        System.out.printf("%nPROMEDIO GENERAL DE SALARIOS: $%.2f%n", promedio);

        //SUMA POR DEPARTAMENTO
        Map<String, Double> totalPorDpto = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)));
        System.out.println("\n *** SUMA TOTAL DE SALARIOS POR DEPARTAMENTO ****");
        totalPorDpto.forEach((d,t) ->
                System.out.printf("  - %-12s: $%,.2f%n", d, t));  //% agrega separadores de miles

        //----- TOP 2 ----
        List<String> top2 = empleados.stream()
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .limit(2)
                .map(e -> String.format("%s (Salario: $%.2f)", e.getNombre() + " " + e.getApellido(),e.getSalario()))
                .toList();

        System.out.println("\n *** TOP 2 EMPLEADOS MEJOR PAGOS ***");
        IntStream.range(0, top2.size())
                .forEach(i -> System.out.printf("%dº %s%n", i + 1, top2.get(i)));
    }
}
