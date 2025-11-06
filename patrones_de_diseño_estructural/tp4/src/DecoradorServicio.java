// Decorador genérico - Simplifica GarantiaExtendida y ServicioInstalacion en una sola clase
public class DecoradorServicio extends DecoradorComponentePC {
    private String tipoServicio;
    private double costoAdicional;

    public DecoradorServicio(ComponentePC componente, String tipoServicio, double costoAdicional) {
        super(componente);
        this.tipoServicio = tipoServicio;
        this.costoAdicional = costoAdicional;
    }

    @Override
    public double obtenerPrecio() {
        return super.obtenerPrecio() + costoAdicional;
    }

    @Override
    public void mostrarDetalle(String indent) {
        super.mostrarDetalle(indent);
        System.out.println(indent + "+ " + tipoServicio + " - $" + costoAdicional);
    }
}
