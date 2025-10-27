package modelos;

import java.time.LocalDate;

public class Reporte {
    //Definimos los atributos de la clase reporte
    private final String titulo;
    private final String cuerpoPrincipal;
    private final String encabezado;
    private final String pieDePagina;
    private final LocalDate fecha;
    private final String autor;
    private final Tipo_Orientacion orientacion;

    //Construimos el objeto en base a su builder
    public Reporte(ReporteBuilder builder) {
        this.titulo = builder.titulo;
        this.cuerpoPrincipal = builder.cuerpoPrincipal;
        this.encabezado = builder.encabezado;
        this.pieDePagina = builder.pieDePagina;
        this.fecha = builder.fecha;
        this.autor = builder.autor;
        this.orientacion = builder.orientacion;
    }
    //Clase Builder estática anidada
    public static class ReporteBuilder {
        //Parámetros obligatorios
        private final String titulo;
        private final String cuerpoPrincipal;

        //Parámetros opcionales con valores por defecto
        private String encabezado = "";
        private String pieDePagina = "";
        private LocalDate fecha = LocalDate.now();
        private String autor = "Desconocido";
        private Tipo_Orientacion orientacion = Tipo_Orientacion.VERTICAL;

        // Constructor del Builder con parámetros obligatorios
        public ReporteBuilder(String titulo, String cuerpoPrincipal) {
            this.titulo = titulo;
            this.cuerpoPrincipal = cuerpoPrincipal;
        }

        // Métodos para establecer los parámetros opcionales
        public ReporteBuilder conEncabezado(String encabezado) {
            this.encabezado = encabezado;
            return this;
        }

        public ReporteBuilder conPieDePagina(String pieDePagina) {
            this.pieDePagina = pieDePagina;
            return this;
        }

        public ReporteBuilder conFecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }
        public ReporteBuilder conAutor(String autor) {
            this.autor = autor;
            return this;
        }
        public ReporteBuilder conOrientacion(Tipo_Orientacion orientacion) {
            this.orientacion = orientacion;
            return this;
        }
        // Método build para construir el objeto Reporte
        public Reporte build() {
            return new Reporte(this);
        }
        
    }

    //Override del método toString para mostrar el reporte
    @Override
    public String toString() {
        return "Reporte{" +
                "titulo='" + titulo + '\'' +
                ", cuerpoPrincipal='" + cuerpoPrincipal + '\'' +
                ", encabezado='" + encabezado + '\'' +
                ", pieDePagina='" + pieDePagina + '\'' +
                ", fecha=" + fecha +
                ", autor='" + autor + '\'' +
                ", orientacion=" + orientacion +
                '}';
    }

}
