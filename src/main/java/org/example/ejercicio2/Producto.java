package org.example.ejercicio2;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

}
