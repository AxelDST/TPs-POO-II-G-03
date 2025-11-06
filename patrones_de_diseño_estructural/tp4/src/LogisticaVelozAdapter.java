class LogisticaVelozAdapter implements IServicioEnvio {

    private ApiLogisticaVeloz api; // Composición

    public LogisticaVelozAdapter(ApiLogisticaVeloz api) {
        this.api = api;
    }

    // Traduce la llamada del sistema interno al método del SDK externo
    @Override
    public float calcularCosto(String codigoPostal) {
        System.out.print("Adaptador: Traduciendo calcularCosto() → cotizarEnvio()... ");
        int cp = Integer.parseInt(codigoPostal);
        Cotizacion cot = api.cotizarEnvio(cp);
        return cot.getCosto();
    }

    @Override
    public String obtenerTiempoEstimado(String codigoPostal) {
        System.out.print("Adaptador: Traduciendo obtenerTiempoEstimado() → cotizarEnvio()... ");
        int cp = Integer.parseInt(codigoPostal);
        Cotizacion cot = api.cotizarEnvio(cp);
        return cot.getDiasEntrega() + " días hábiles";
    }

    @Override
    public String despacharPedido(String direccion, String codigoPostal, String idPedido) {
        System.out.print("Adaptador: Traduciendo despacharPedido() → enviarPaquete()... ");
        int cp = Integer.parseInt(codigoPostal);
        DatosEnvio datos = new DatosEnvio(direccion, cp, idPedido);
        return api.enviarPaquete(datos);
    }
}
