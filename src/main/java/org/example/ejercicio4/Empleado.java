package org.example.ejercicio4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Empleado {
    private String nombre;
    private String apellido;
    private String departamento;
    private double salario;
    private int edad;
}
