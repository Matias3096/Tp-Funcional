package org.example.ejercicio3;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class generadorLibro {

    private static final List<String> titulos = List.of(
            "El Codigo Da Vinci", "1984", "Un Mundo Feliz", "Cien Años de Soledad", "El Hobbit",
            "Algebra Lineal y Geometria Analitica", "Patrones UML", "Don Quijote", "La Odisea", "El Principito",
            "Fisica Universitaria", "Quimica General","Harry Potter y la piedra filosofal", "El alquimista", "El símbolo perdido", "Los pilares de la Tierra",
            "Cincuenta sombras de Grey", "Juego de tronos", "It", "El paciente inglés", "La chica del tren",
            "El código del dinero", "Los hombres que no amaban a las mujeres", "La catedral del mar",
            "El nombre del viento", "Memorias de una geisha", "El psicoanalista", "La sombra del viento",
            "Los juegos del hambre", "Millennium: Los hombres que no amaban a las mujeres", "El último deseo",
            "Buenos presagios", "American Gods", "La casa de los espíritus", "El retrato de Dorian Gray",
            "Las crónicas de Narnia", "Drácula", "Orgullo y prejuicio", "Crimen y castigo", "Anna Karénina",
            "Madame Bovary", "Moby Dick", "1984"
    );

    private static final List<String> autores = List.of(
            "J.K. Rowling", "Paulo Coelho", "Dan Brown", "Ken Follett", "E.L. James",
            "George R.R. Martin", "Stephen King", "Michael Ondaatje", "Paula Hawkins",
            "Raimon Samsó", "Stieg Larsson", "Ildefonso Falcones", "Patrick Rothfuss",
            "Arthur Golden", "John Katzenbach", "Carlos Ruiz Zafón", "Suzanne Collins",
            "Stieg Larsson", "Andrzej Sapkowski", "Neil Gaiman", "Neil Gaiman",
            "Isabel Allende", "Oscar Wilde", "C.S. Lewis", "Bram Stoker",
            "Jane Austen", "Fyodor Dostoyevsky", "Leo Tolstoy", "Gustave Flaubert",
            "Herman Melville", "Dan Brown", "George Orwell", "Aldous Huxley", "Gabriel García Márquez", "J.R.R. Tolkien",
            "Stanley Grossman", "Gang of Four", "Miguel de Cervantes", "Homero", "Antoine de Saint-Exupéry"
    );

    private static final Random randomLibros = new Random();
    public static List<Libro> generarLibros(int cantidad) {
        return IntStream.range(0, cantidad)
                .mapToObj(i-> new Libro (
                        titulos.get(randomLibros.nextInt(titulos.size())),
                        autores.get(randomLibros.nextInt(autores.size())),
                        randomLibros.nextInt(100,601), //paginas entre 100 y 600
                        Math.round((20 + randomLibros.nextDouble() * 180) *100.0)/100.0 //precio entre 20 y 200
                ))
                .collect(Collectors.toList());
    }
}
