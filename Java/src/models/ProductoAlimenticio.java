public class ProductoAlimenticio extends Producto{ //Herencia
    private String fechaCaducidad;

    public ProductoAlimenticio(String nombre, double precioBase, int cantidadDisponible, String fechaCaducidad) {
        super(nombre, precioBase, cantidadDisponible);
        this.fechaCaducidad = fechaCaducidad;
    }
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}
