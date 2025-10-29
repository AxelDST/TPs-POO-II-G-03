import java.time.LocalDate;

import modelos.Reporte;
import modelos.Tipo_Orientacion;

public class App {
    public static void main(String[] args) throws Exception {
        // Ejemplo Requerimiento 2: construir un Reporte con el patrón Builder y mostrarlo
        Reporte reporte = new Reporte.ReporteBuilder("Informe de Ventas", "Ventas totales: $12345")
                .conEncabezado("Empresa XYZ - Reporte")
                .conPieDePagina("Confidencial")
                .conAutor("Axel")
                .conFecha(LocalDate.of(2025, 10, 27))
                .conOrientacion(Tipo_Orientacion.HORIZONTAL)
                .build();

        System.out.println(reporte);

        // Agrega un espacio para que se vea más limpio
        System.out.println("\n");

        // Ejemplo Requerimiento 3: usar el Gestor de Configuración Global (Singleton)
        // --- REQUERIMIENTO 3: PRUEBA DEL SINGLETON ---
        System.out.println("--- Demostración del Singleton (Requerimiento 3) ---");

        System.out.println("Módulo de Finanzas pide la instancia...");
        GestorConfiguracion configFinanzas = GestorConfiguracion.getInstance();
        System.out.println("URL de BD (Finanzas): " + configFinanzas.getUrlBd());

        System.out.println("\nMódulo de Marketing pide la instancia...");
        GestorConfiguracion configMarketing = GestorConfiguracion.getInstance();
        System.out.println("Path de Reportes (Marketing): " + configMarketing.getPathReportes());

        // Prueba de Unicidad
        boolean sonLaMismaInstancia = (configFinanzas == configMarketing);
        System.out.println("\n¿'configFinanzas' y 'configMarketing' son la misma instancia?");
        System.out.println("Resultado: " + sonLaMismaInstancia); // Deberá imprimir 'true'
    }
}
