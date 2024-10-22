import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Producto;
import models.ProductoElectronico;
import models.ProductoAlimenticio;

public class VentasController {
    private Scanner scanner = new Scanner(System.in);
    private List<Producto> productos = new ArrayList<>();

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

        // Aquí puedes agregar lógica para decidir qué tipo de producto registrar
        // Por ejemplo:
        System.out.println("Ingrese el tipo de producto (1: Electrónico, 2: Alimenticio): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea

        Producto producto;
        if (tipo == 1) {
            System.out.println("Ingrese la garantía: ");
            int garantia = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea
            producto = new ProductoElectronico(nombre, precioBase, cantidad, garantia);
        } else {
            System.out.println("Ingrese la fecha de caducidad: ");
            String fechaCaducidad = scanner.nextLine();
            producto = new ProductoAlimenticio(nombre, precioBase, cantidad, fechaCaducidad);
        }

        productos.add(producto);
        System.out.println("Producto registrado: " + producto.getNombre());
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
                    // Lógica para registrar venta
                    break;
                case 3:
                    mostrarProductos();
                    break;
                case 4:
                    // Lógica para predecir precios
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

