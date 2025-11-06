// Interfaz base para el patrón Composite
// Define operaciones comunes a componentes simples y compuestos
public interface ComponentePC {
    double obtenerPrecio();
    void mostrarDetalle(String indent);
}
