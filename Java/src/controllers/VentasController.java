import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import models.Producto;
import models.ProductoElectronico;
import models.ProductoAlimenticio;
import models.PrediccionPrecios;

public class VentasController {
    private Scanner scanner = new Scanner(System.in);
    private List<Producto> productos = new ArrayList<>();
    private List<String> ventas = new ArrayList<>(); // Lista para almacenar ventas
    private PrediccionPrecios prediccionPrecios = new PrediccionPrecios(); // Instancia para predicción de precios

    public void mostrarMenu() {
        System.out.println("1. Registrar Producto");
        System.out.println("2. Registrar Venta");
        System.out.println("3. Mostrar Productos");
        System.out.println("4. Predecir Precio");
        System.out.println("5. Salir");
    }

    public void registrarProducto() {
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio base: ");
        double precioBase = scanner.nextDouble();
        System.out.println("Ingrese la cantidad disponible: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea

        System.out.println("Ingrese el tipo de producto (1: Electrónico, 2: Alimenticio): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea

        Producto producto;
        if (tipo == 1) {
            System.out.println("Ingrese la garantía en años: ");
            int garantia = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea
            producto = new ProductoElectronico(nombre, precioBase, cantidad, garantia);
        } else {
            System.out.println("Ingrese la fecha de caducidad (DD/MM/AAAA): ");
            String fechaCaducidad = scanner.nextLine();
            producto = new ProductoAlimenticio(nombre, precioBase, cantidad, fechaCaducidad);
        }

        productos.add(producto);
        System.out.println("Producto registrado: " + producto.getNombre());

        // Guardar en datos_ventas.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos_ventas.txt", true))) {
            bw.write(cantidad + "," + precioBase);
            bw.newLine(); // Agregar una nueva línea después de cada entrada
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en datos_ventas.txt: " + e.getMessage());
        }
    }

    public void registrarVenta() {
        System.out.println("Ingrese el nombre del producto que desea vender: ");
        String nombreProducto = scanner.nextLine();
        Producto productoEncontrado = null;

        // Buscar el producto en la lista
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Ingrese la cantidad a vender: ");
        int cantidadVenta = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea

        if (cantidadVenta > productoEncontrado.getCantidadDisponible()) {
            System.out.println("No hay suficiente cantidad disponible para la venta.");
            return;
        }

        // Actualizar cantidad disponible
        productoEncontrado.setCantidadDisponible(productoEncontrado.getCantidadDisponible() - cantidadVenta);
        String venta = "Venta de " + cantidadVenta + " unidades de " + productoEncontrado.getNombre();
        ventas.add(venta); // Guardar la venta registrada
        System.out.println("Venta registrada: " + venta);

        // Guardar la venta en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos_ventas.txt", true))) {
            bw.write("Venta: " + cantidadVenta + "," + productoEncontrado.getNombre());
            bw.newLine(); // Agregar una nueva línea después de cada entrada
        } catch (IOException e) {
            System.out.println("Error al guardar la venta en datos_ventas.txt: " + e.getMessage());
        }
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        for (Producto prod : productos) {
            System.out.println("Nombre: " + prod.getNombre() + ", Precio Base: " + prod.getPrecioBase() + ", Cantidad: " + prod.getCantidadDisponible());
        }
    }


    public void iniciar() {
        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    registrarVenta();
                    break;
                case 3:
                    mostrarProductos();
                    break;
                case 4:
                    predecirPrecios();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
