// Componente hoja genérico - Simplifica CPU, RAM, SSD, PlacaMadre en una sola clase
public class ComponenteSimple implements ComponentePC {
    private String tipo;
    private String descripcion;
    private double precio;

    public ComponenteSimple(String tipo, String descripcion, double precio) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public double obtenerPrecio() {
        return precio;
    }

    @Override
    public void mostrarDetalle(String indent) {
        System.out.println(indent + tipo + " " + descripcion + " - $" + precio);
    }
}
