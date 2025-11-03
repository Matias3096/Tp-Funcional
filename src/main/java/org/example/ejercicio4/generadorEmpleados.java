package org.example.ejercicio4;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class generadorEmpleados {
    private static final List<String> nombresEmpleados = List.of(
            "Ana", "Luis", "Maria", "Carlos", "Elena", "Pedro", "Lucia", "Jorge", "Laura", "Miguel",
            "Sofia", "Diego", "Valentina", "Bruno", "Juana", "Tomas", "Renata", "Facundo", "Camila", "Ignacio"
    );
    private static final List<String> apellidosEmpleados = List.of(
            "Fernández", "Gómez", "López", "Martínez", "Rodríguez", "García", "Pérez", "González", "Sánchez", "Ramírez",
            "Díaz", "Castro", "Romero", "Alvarez", "Méndez", "Acosta", "Flores", "Benítez", "Ruiz", "Herrera"
    );
    private static final List<String> departamentoEmpleados = List.of(
            "Ventas", "IT", "RRHH", "Contabilidad", "Marketing", "Logistica"
    );

    private static final Random randomEmpleados = new Random();

    public static List<Empleado> generarEmpleados (int cantidad) {
        return IntStream.range(0, cantidad)
                .mapToObj(i -> new Empleado(
                        nombresEmpleados.get(randomEmpleados.nextInt(nombresEmpleados.size())),
                        apellidosEmpleados.get(randomEmpleados.nextInt(apellidosEmpleados.size())),
                        departamentoEmpleados.get(randomEmpleados.nextInt(departamentoEmpleados.size())),
                        Math.round((1500 + randomEmpleados.nextDouble() * 35000) + 10000.0)/10.0, //salario entre 1500 y 5000
                        randomEmpleados.nextInt(22,56) //edad entre 22 y 55
                ))
                .collect(Collectors.toList());
    }
}
