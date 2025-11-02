package org.example.modelo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneradorAlumnos {
    private static final List<String> NOMBRES = List.of(
            "Sofía", "Martín", "Lucía", "Mateo", "Valentina", "Bautista", "Emma", "Juan",
            "Juana", "Teo", "Olivia", "Lucas", "Isabella", "Benjamín", "Mía", "Tomás",
            "Catalina", "Santino", "Emilia", "Thiago", "Renata", "Dante"
            , "Zoe", "Lautaro", "Victoria", "Jerónimo", "Aitana", "Facundo",
            "Brunella", "Ignacio"
    );

    private static final List<String> CURSOS = List.of (
            "Matematica", "Literatura", "Historia", "Biologia", "Fisica",
            "Quimica", "Ingles", "Arte", "Musica", "Educacion Fisica"
    );

    private static final Random RANDOM = new Random();

    public static List<Alumno> generar(int cantidad) {
        return IntStream.range(0, cantidad)
                .mapToObj( i -> new Alumno(
                        NOMBRES.get(RANDOM.nextInt(NOMBRES.size())),
                        Math.round((2.0 + RANDOM.nextDouble() *8.0) * 100.0) / 100, //2 decimales
                        CURSOS.get(RANDOM.nextInt(CURSOS.size()))
                ))
                .collect(Collectors.toList());
    }
}
