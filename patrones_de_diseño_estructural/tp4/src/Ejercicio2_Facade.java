import java.io.*;
import java.nio.file.*;
import java.util.*;

// Subsistemas simulados
class ConectorDB {
    public void conectar() { System.out.println("DB: conectado"); }
    public void desconectar() { System.out.println("DB: desconectado"); }
}

class LectorDeDatos {
    public Map<String, String> obtenerDatosCliente(int idCliente) {
        System.out.println("Leyendo datos de cliente " + idCliente);
        Map<String,String> datos = new HashMap<>();
        datos.put("CUIT", "20-12345678-9");
        datos.put("RazonSocial", "Cliente Ejemplo SA");
        return datos;
    }
}

class ServicioWebAFIP {
    public Map<String, Object> obtenerDatosFiscales(String cuit) {
        System.out.println("AFIP: consultando datos fiscales de " + cuit);
        Map<String,Object> r = new HashMap<>();
        r.put("categoria", "Responsable Inscripto");
        r.put("alicuotaIVA", 0.21);
        return r;
    }
}

class ProcesadorDeImpuestos {
    public double calcularTotal(Map<String, String> datosCliente, Map<String,Object> datosAfip) {
        System.out.println("Procesando impuestos...");
        // Cálculo ficticio
        return 100000 * (double)datosAfip.get("alicuotaIVA");
    }
}

class RenderizadorPDF {
    public Path renderizar(String titulo, String cuerpo) {
        System.out.println("Renderizando PDF...");
        try {
            Path out = Paths.get("patrones_de_diseño_estructural/tp4/salidas/reporte_fiscal.pdf");
            Files.write(out, (titulo + "\n\n" + cuerpo).getBytes());
            return out;
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el PDF", e);
        }
    }
}

// Facade
class GeneradorReporteFiscalFacade {
    private final ConectorDB db = new ConectorDB();
    private final LectorDeDatos lector = new LectorDeDatos();
    private final ServicioWebAFIP afip = new ServicioWebAFIP();
    private final ProcesadorDeImpuestos proc = new ProcesadorDeImpuestos();
    private final RenderizadorPDF pdf = new RenderizadorPDF();

    public Path generarPDF(int idCliente) {
        db.conectar();
        try {
            Map<String,String> datosCliente = lector.obtenerDatosCliente(idCliente);
            Map<String,Object> datosAfip = afip.obtenerDatosFiscales(datosCliente.get("CUIT"));
            double totalImpuestos = proc.calcularTotal(datosCliente, datosAfip);

            String titulo = "Reporte Fiscal - " + datosCliente.get("RazonSocial");
            String cuerpo = "CUIT: " + datosCliente.get("CUIT") + "\n"
                    + "Categoría: " + datosAfip.get("categoria") + "\n"
                    + "Total impuestos estimado: $" + totalImpuestos + "\n";

            return pdf.renderizar(titulo, cuerpo);
        } finally {
            db.desconectar();
        }
    }
}

// Demo
public class Ejercicio2_Facade {
    public static void main(String[] args) {
        GeneradorReporteFiscalFacade facade = new GeneradorReporteFiscalFacade();
        Path archivo = facade.generarPDF(123);
        System.out.println("Reporte generado: " + archivo.toAbsolutePath());
    }
}

