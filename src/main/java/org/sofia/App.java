package org.sofia;

import org.sofia.entity.Juguete;
import org.sofia.service.JugueteService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final JugueteService productoService = new JugueteService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- CRUD de juguetes---");
            System.out.println("1. Crear juguete");
            System.out.println("2. Leer juguete");
            System.out.println("3. Actualizar juguete");
            System.out.println("4. Eliminar juguete");
            System.out.println("5. Listar todos los juguetes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> leerProducto();
                case 3 -> actualizarProducto();
                case 4 -> eliminarProducto();
                case 5 -> listarProductos();
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
        productoService.cerrar();
        scanner.close();
    }

    private static void crearProducto() {
        System.out.print("Nombre del juguete: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del juguete: ");
        BigDecimal precio = scanner.nextBigDecimal();

        Juguete producto = new Juguete();
        producto.setNombre(nombre);
        producto.setPrecio(precio);

        productoService.crearProducto(producto);
        System.out.println("Producto creado con éxito");
    }

    private static void leerProducto() {
        System.out.print("ID del juguete: ");
        Long id = scanner.nextLong();
        Juguete producto = productoService.obtenerProducto(id);
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    private static void actualizarProducto() {
        System.out.print("ID del juguete a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Juguete producto = productoService.obtenerProducto(id);
        if (producto != null) {
            System.out.print("Nuevo nombre (deje en blanco para mantener el actual): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                producto.setNombre(nombre);
            }

            System.out.print("Nuevo precio (0 para mantener el actual): ");
            BigDecimal precio = scanner.nextBigDecimal();
            if (precio.compareTo(BigDecimal.ZERO) != 0) {
                producto.setPrecio(precio);
            }

            productoService.actualizarProducto(producto);
            System.out.println("juguete actualizado con éxito");
        } else {
            System.out.println("juguete no encontrado");
        }
    }

    private static void eliminarProducto() {
        System.out.print("ID del juguete a eliminar: ");
        Long id = scanner.nextLong();
        productoService.eliminarProducto(id);
        System.out.println("juguete eliminado con éxito");
    }

    private static void listarProductos() {
        List<Juguete> productos = productoService.obtenerTodosLosProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay juguetes registrados");
        } else {
            for (Juguete producto : productos) {
                System.out.println(producto);
            }
        }
    }
}