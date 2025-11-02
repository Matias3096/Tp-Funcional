package org.example.ejercicio2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneradorProductos {
    private static final List<String> nombresProductos = List.of(
            "Notebook", "Mouse", "Teclado", "Monitor", "Auriculares",
            "Impresora", "Webcam", "Microfono", "Parlante", "Mousepad",
            "Silla", "Mesa", "Lampara", "Cargador", "USB",
            "SSD", "Router", "Cable HDMI", "Adaptador", "Smartwatch"
    );
    private static final List<String> categoriasProductos = List.of(
            "Tecnologia", "Oficina", "Accesorios", "Audio", "Almacenamiento"
    );

    private static final Random randomProductos = new Random();

    public static List<Producto> generarProducto(int cantidadProducto) {
        return IntStream.range(0, cantidadProducto)
                .mapToObj( i -> new Producto(
                        nombresProductos.get(randomProductos.nextInt(nombresProductos.size())),
                        categoriasProductos.get(randomProductos.nextInt(categoriasProductos.size())),
                        Math.round((50 + randomProductos.nextDouble() * 950) * 100.00) / 100.0, // precio entre 50 y 1000
                        randomProductos.nextInt(1, 101) //Stock entre 1 y 100
                ))
                .collect(Collectors.toList());
    }
}
