// Decorador base para el patrón Decorator
// Permite agregar funcionalidades adicionales a los componentes de forma dinámica
public abstract class DecoradorComponentePC implements ComponentePC {
    protected ComponentePC componenteDecorado;

    public DecoradorComponentePC(ComponentePC componente) {
        this.componenteDecorado = componente;
    }

    @Override
    public double obtenerPrecio() {
        return componenteDecorado.obtenerPrecio();
    }

    @Override
    public void mostrarDetalle(String indent) {
        componenteDecorado.mostrarDetalle(indent);
    }
}
