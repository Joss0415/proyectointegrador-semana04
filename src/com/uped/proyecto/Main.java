package com.uped.proyecto;

import com.uped.proyecto.modelo.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Pedido pedido = new Pedido(101);

        ConfiguracionReporte config = new ConfiguracionReporte.Builder()
                .titulo("Ventas Q3")
                .conGrafico()
                .build();

        System.out.println(config);

        Carrito carrito = new Carrito();
        carrito.agregar("Café");
        carrito.agregar("Azúcar");
        carrito.getItems().clear(); // solo modifica la copia
        System.out.println("Items en el carrito: " + carrito.getItems().size());

        Empleado empleado = new Empleado("04512378-9", "Analista");
        System.out.println(empleado);
        empleado.ascender("Analista Senior");
        System.out.println(empleado);

        Punto original = new Punto(2, 3);
        Punto movido = original.mover(1, 1);
        System.out.println("Original: " + original);
        System.out.println("Movido: " + movido);

        Vehiculo vehiculo = new Vehiculo("N123-456", "Toyota");
        System.out.println(vehiculo);

        var l1 = new LibroBiblioteca("Clean Code", "R. Martin", 3);
        var l2 = LibroBiblioteca.unico("Effective Java", "J. Bloch");

        l1.prestar();
        l2.prestar();
        l2.prestar();

        Vehiculo v1 = Vehiculo.nuevo("P123-789", "Kia");
        System.out.println(v1);
        v1.recorrer(150);
        System.out.println(v1);
        v1.recorrer(-20);

        Suscripcion basica = new Suscripcion.Builder()
                .usuario("Julia")
                .build();

        System.out.println("Básica: " + basica);

        Suscripcion premium = new Suscripcion.Builder()
                .usuario("Josue")
                .plan("PREMIUM")
                .inicio(LocalDate.of(2026, 11, 1))
                .meses(11)
                .build();

        System.out.println("Premium: " + premium);

    }
}