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
    }
}
