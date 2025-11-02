package org.example.modelo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Alumno {
    private String nombre;
    private double nota;
    private String curso;
}
