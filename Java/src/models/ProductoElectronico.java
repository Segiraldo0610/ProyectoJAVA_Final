public class ProductoElectronico extends Producto { // Herencia
    private int garantia;

    public ProductoElectronico(String nombre, double precioBase, int cantidadDisponible, int garantia) {
        super(nombre, precioBase, cantidadDisponible);
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }
    
    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
}

