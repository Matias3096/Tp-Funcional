package org.example.ejercicio3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private double precio;
}
