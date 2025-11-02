package org.example.ejercicio3;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.*;

import java.util.List;

public class MainLibros {
    public static void main(String[] args) {
    //---------crear libros---------------
        List<Libro> libros = generadorLibro.generarLibros(30);

    //------Lista completa de libros
        System.out.println("LISTA COMPLETA DE LIBROS");
        libros.forEach( l ->
                System.out.println("- " + l.getTitulo() + "\n|  Autor:  " + l.getAutor() +
                        "  | Paginas: " + l.getPaginas() + "| Precio: " + l.getPrecio())
         );

        //------Libros con mas de 300 paginas, ordenados alfabeticamente (punto 1)----------

        List<String> titulosLargos = libros.stream()
                .filter(l -> l.getPaginas() > 300 )
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\n **** LIBROS CON MAS DE 300 PAGINAS (ordenados alfabeticamente) ****");
        if (titulosLargos.isEmpty()) {
            System.out.println(" \n NO HAY LIBROS CON MAS DE 300 PAGINAS");
        } else {
            titulosLargos.forEach( t ->  System.out.println( "   -" + t));
        }

        //-------------- Promedio de paginas de todos los libros----------------
        double  promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);
        System.out.println("\n **** PROMEDIO DE PAGINAS ****");
        System.out.printf("Promedio general : %.0f paginas%n", promedioPaginas );

        //--------------AGRUPAR POR AUTOR Y CONTAR CUANTOS LIBROS TIENE CADA UNO-------------------
        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(Libro::getAutor,
                        Collectors.counting()));

        System.out.println("\n **** CANTIDAD DE LIBROS POR AUTOR ****");
        librosPorAutor.forEach((autor,cantidad) ->
                System.out.println("    -" +autor + " : " + cantidad + "  Libro/s"));

        //------ Libro mas caro ----------------------
        Optional<Libro> masCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));

        System.out.println("\n **** Libro mas caro ****");
        masCaro.ifPresent( l ->
                System.out.println("Titulo: " + l.getTitulo() + "| Autor: " + l.getAutor() + "|  Precio: " + l.getPrecio())
        );


    }
}
