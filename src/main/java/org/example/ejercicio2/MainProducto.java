package org.example.ejercicio2;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainProducto {
    public static void main(String[] args) {
        //Crear productos de manera aleatoria
        List<Producto> productos = GeneradorProductos.generarProducto(40);

        //Lista completa de productos
        System.out.println("\n LISTA COMPLETA DE PRODUCTOS");  //Se podria ordenar por tipo, de forma alfabetica? Osea por categoria
        productos.forEach( p ->
                System.out.println("Nombre: " + p.getNombre() + "|Categoria: " + p.getCategoria() +
                        "|Precio: $" + p.getPrecio() + "|Stock: " + p.getStock()));

        //Productos caros con precio >100
        List<Producto> caros = productos.stream()
                .filter( p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());

        System.out.println("\n ******PRODUCTOS CAROS DE MAS DE $100 ******");
        if (caros.isEmpty()) {
            System.out.println("\n No hay productos caros.");
        } else {
            caros.forEach( p -> System.out.println("   -" + p.getNombre() + " -> $" + p.getPrecio()));
        }

        //----------4 STOCK POR CATEGORIA ------------------
        Map<String,Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)));

        System.out.println("\n ***** STOCK TOTAL POR CATEGORIA ****");
        stockPorCategoria.forEach((cat, stock) -> System.out.println("   -" + cat + " -> $" + stock + " unidades"));


        //------- 5 LISTADO SIMPLE CON: ------
        String listado = productos.stream()
                .map(p -> "\n" + p.getNombre() + "($ " + p.getPrecio() + ")")
                .collect(Collectors.joining(", "));

        System.out.println("\n****  LISTADO SIMPLE (nombre y precio) ****");
        System.out.println(listado);


        //-----------6 PRECIO PROMEDIO GENERAL Y POR CATEGORIA -----------------

        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        System.out.println("\n *** PRECIO PROMEDIO***");
        System.out.println("\n PROMEDIO GENERAL:$ " + promedioGeneral);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.averagingDouble(Producto::getPrecio)));
        System.out.println("\n ***  PROMEDIO POR CATEGORIA ***");
        promedioPorCategoria.forEach((cat, prom) ->
                System.out.println("   -" + cat + " -> $" + prom ));

    }
}
