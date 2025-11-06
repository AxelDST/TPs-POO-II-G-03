public class SistemaDeEnvios {
    public static void main(String[] args) {

        // Creamos la instancia del SDK externo
        ApiLogisticaVeloz apiVeloz = new ApiLogisticaVeloz();

        // Creamos el adaptador que implementa la interfaz esperada por el sistema
        IServicioEnvio servicio = new LogisticaVelozAdapter(apiVeloz);

        // Ahora el sistema puede trabajar con la API externa sin modificar su código
        System.out.println("Costo: $" + servicio.calcularCosto("5000"));
        System.out.println("Tiempo estimado: " + servicio.obtenerTiempoEstimado("5000"));
        System.out.println("Despacho: " + servicio.despacharPedido("Av. las heras", "5000", "PED123"));
    }

    
}
