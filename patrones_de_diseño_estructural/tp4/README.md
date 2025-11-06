## Metodología de Trabajo

### Escenario 1 – Ensamblaje de computadoras (Composite + Decorator)

**1. Análisis del Escenario:**  
*(Describir aquí las clases principales, sus responsabilidades y los problemas de acoplamiento o complejidad detectados.)*  

**2. Identificación del Patrón:**  
*(Indicar qué patrón o combinación de patrones se aplicó y por qué son adecuados para este caso.)*  

**3. Justificación de la Elección:**  
*(Explicar brevemente por qué los patrones elegidos resuelven los problemas detectados, vinculándolos con su intención original.)*  


---

### Escenario 2 – Generación de reporte fiscal (Facade)

**1. Análisis del Escenario:**  
El sistema debía generar un reporte fiscal en PDF, pero para hacerlo intervenían varias clases independientes: una para conectar con la base de datos, otra para leer datos del cliente, otra para consultar la AFIP, una más para procesar impuestos y otra para renderizar el PDF.  
Esto generaba **acoplamiento y complejidad**: el código que pedía el reporte debía conocer y coordinar demasiadas clases y pasos internos.

**2. Identificación del Patrón:**  
Se aplicó el patrón **Facade**, cuyo propósito es **proporcionar una interfaz unificada y simple** para un conjunto complejo de subsistemas.  
La clase `GeneradorReporteFiscalFacade` actúa como punto de acceso único que coordina las operaciones de los módulos internos (`ConectorDB`, `LectorDeDatos`, `ServicioWebAFIP`, `ProcesadorDeImpuestos`, `RenderizadorPDF`).

**3. Justificación de la Elección:**  
El patrón **Facade** reduce el acoplamiento y simplifica el uso del sistema, ya que el cliente solo interactúa con un método (`generarPDF`) en lugar de manejar cada clase interna.  
Esto mejora la **legibilidad**, facilita el **mantenimiento** y permite que los subsistemas cambien sin afectar el código externo, cumpliendo con la intención del patrón de **ocultar la complejidad del sistema detrás de una interfaz sencilla**.

**El diagrama de clases se encuentra disponible en su carpeta, en el archivo DC_Ejer2.md listo para copiar y pegar en mermaid.**

---

### Escenario 3 – Servicio de logística (Adapter)

**1. Análisis del Escenario:**  
En este caso, el sistema interno cuenta con una interfaz denominada `IServicioEnvio`, la cual define los métodos que utiliza la aplicación para interactuar con cualquier servicio de envío: `calcularCosto()`, `obtenerTiempoEstimado()` y `despacharPedido()`. Sin embargo, la empresa comenzó a trabajar con una API externa llamada `ApiLogisticaVeloz`, que ofrece funcionalidades similares pero con una estructura distinta.  
Esta API utiliza los métodos `cotizarEnvio(int cpDestino)` y `enviarPaquete(DatosEnvio datos)`, devolviendo objetos de tipo `Cotizacion` y recibiendo datos en una clase `DatosEnvio`.  
El problema surge porque las firmas de los métodos y los tipos de datos no coinciden: el sistema interno usa `String` para los códigos postales, mientras que la API requiere `int`, y además los nombres y estructuras de los métodos son diferentes. Por lo tanto, el sistema no puede utilizar la API directamente sin romper su propia interfaz o modificar código interno.

**2. Identificación del Patrón:**  
Para resolver esta incompatibilidad se aplicó el patrón **Adapter**. Este patrón permite conectar dos interfaces que no son compatibles sin necesidad de modificar sus implementaciones originales.  

**3. Justificación de la Elección:**  
El uso del patrón Adapter es adecuado porque permite reutilizar la API externa sin modificar su código, respetando al mismo tiempo la estructura definida en el sistema interno. Gracias al adapter, el cliente puede seguir utilizando su interfaz `IServicioEnvio` sin preocuparse por los detalles técnicos o las diferencias de formato que presenta el proveedor externo.  
Además, este enfoque reduce el acoplamiento, ya que los cambios futuros en la API se manejarían únicamente dentro del adaptador, sin afectar al resto de la aplicación. 

