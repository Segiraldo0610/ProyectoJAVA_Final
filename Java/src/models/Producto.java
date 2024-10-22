public class Producto{
    private String nombre;
    private double precioBase;
    private int cantidadDisponible;

    public Producto(String nombre, double precioBase, int cantidadDisponible){
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getNombre(){
        return nombre;
    }
    public double getPrecioBase(){
        return precioBase;
    }
    public int getCantidadDisponible(){
        return cantidadDisponible;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPrecioBase(double precioBase){
        this.precioBase = precioBase;
    }
    public void setCantidadDisponible(int cantidadDisponible){
        this.cantidadDisponible = cantidadDisponible;
    }
}
