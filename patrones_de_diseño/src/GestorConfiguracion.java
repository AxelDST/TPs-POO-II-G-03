/**
 * Requerimiento 3: Gestor de Configuración Global.
 *
 * Esta clase implementa el patrón Singleton para asegurar que solo
 * exista una única instancia en toda la aplicación.
 */


public class GestorConfiguracion {
   // 1. La única instancia de la clase (creada al cargar la clase)
    private static final GestorConfiguracion instancia = new GestorConfiguracion();

    // 2. Los atributos de configuración
    private String urlBd;
    private String userBd;
    private String pathReportes;

    // 3. El Constructor es PRIVADO
    // Esto evita que cualquier otra clase pueda
    // crear una instancia usando 'new GestorConfiguracion()'.
    private GestorConfiguracion() {
        // En un proyecto real, aquí se leerían los valores de un archivo.
        
        this.urlBd = "jdbc:mysql://localhost:3306/mi_db";
        this.userBd = "admin";
        this.pathReportes = "/app/reportes/";
        
        System.out.println("Instancia de GestorConfiguracion CREADA.");
    } 

    // 4. El punto de acceso global (método estático)
    public static GestorConfiguracion getInstance() {
        return instancia;
    }

    // 5. Getters públicos para leer la configuración
    public String getUrlBd() {
        return urlBd;
    }

    public String getUserBd() {
        return userBd;
    }

    public String getPathReportes() {
        return pathReportes;
    }
}
