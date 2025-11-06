import java.util.ArrayList;
import java.util.List;

// Componente compuesto: Gabinete
// Aplica el patrón Composite - puede contener múltiples componentes
public class Gabinete implements ComponentePC {
    private String modelo;
    private double precioBase;
    private List<ComponentePC> componentes;

    public Gabinete(String modelo, double precioBase) {
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.componentes = new ArrayList<>();
    }

    public void agregarComponente(ComponentePC componente) {
        componentes.add(componente);
    }

    public void removerComponente(ComponentePC componente) {
        componentes.remove(componente);
    }

    @Override
    public double obtenerPrecio() {
        double total = precioBase;
        for (ComponentePC comp : componentes) {
            total += comp.obtenerPrecio();
        }
        return total;
    }

    @Override
    public void mostrarDetalle(String indent) {
        System.out.println(indent + "Gabinete " + modelo + " - $" + precioBase);
        for (ComponentePC comp : componentes) {
            comp.mostrarDetalle(indent + "  ");
        }
    }
}
