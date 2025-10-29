package render;

import modelos.Reporte;

// REQUERIMIENTO 1 – MOTOR DE RENDERIZADO (ABSTRACT FACTORY)

/* -------- Fábrica (package-private) -------- */
interface ReporteFactory {
    Renderizador crearRenderizador();
    Compresor crearCompresor();
}

/* -------- Productos abstractos -------- */
interface Renderizador {
    void renderizar(Reporte reporte);
}
interface Compresor {
    void comprimir();
}

/* -------- Productos concretos PDF -------- */
class RenderizadorPDF implements Renderizador {
    public void renderizar(Reporte r) {
        System.out.println("[PDF] Renderizando: " + r);
    }
}
class CompresorPDF implements Compresor {
    public void comprimir() {
        System.out.println("→ Comprimiendo archivo PDF...");
    }
}

/* -------- Productos concretos Excel -------- */
class RenderizadorExcel implements Renderizador {
    public void renderizar(Reporte r) {
        System.out.println("[Excel] Renderizando: " + r);
    }
}
class CompresorExcel implements Compresor {
    public void comprimir() {
        System.out.println("→ Comprimiendo archivo Excel...");
    }
}

/* -------- Productos concretos CSV -------- */
class RenderizadorCSV implements Renderizador {
    public void renderizar(Reporte r) {
        System.out.println("[CSV] Renderizando: " + r);
    }
}
class CompresorCSV implements Compresor {
    public void comprimir() {
        System.out.println("→ Comprimiendo archivo CSV...");
    }
}

/* -------- Fábricas concretas (package-private) -------- */
class PDFReportFactory implements ReporteFactory {
    public Renderizador crearRenderizador() { return new RenderizadorPDF(); }
    public Compresor crearCompresor() { return new CompresorPDF(); }
}

class ExcelReportFactory implements ReporteFactory {
    public Renderizador crearRenderizador() { return new RenderizadorExcel(); }
    public Compresor crearCompresor() { return new CompresorExcel(); }
}

class CSVReportFactory implements ReporteFactory {
    public Renderizador crearRenderizador() { return new RenderizadorCSV(); }
    public Compresor crearCompresor() { return new CompresorCSV(); }
}

/* -------- Clase cliente pública -------- */
public class MotorDeReportes {
    private final Renderizador renderizador;
    private final Compresor compresor;

    public MotorDeReportes(ReporteFactory factory) {
        this.renderizador = factory.crearRenderizador();
        this.compresor = factory.crearCompresor();
    }

    public void procesarReporte(Reporte reporte) {
        renderizador.renderizar(reporte);
        compresor.comprimir();
    }

    // Métodos de conveniencia para crear instancias preconfiguradas
    public static MotorDeReportes crearPDF() {
        return new MotorDeReportes(new PDFReportFactory());
    }
    public static MotorDeReportes crearExcel() {
        return new MotorDeReportes(new ExcelReportFactory());
    }
    public static MotorDeReportes crearCSV() {
        return new MotorDeReportes(new CSVReportFactory());
    }
}
