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
*(Describir las clases del sistema y de la API externa, y los problemas de compatibilidad entre interfaces.)*  

**2. Identificación del Patrón:**  
*(Indicar qué patrón se utilizó y cómo adapta una interfaz a otra.)*  

**3. Justificación de la Elección:**  
*(Explicar por qué el uso de Adapter permite reutilizar la API sin modificarla y cumplir con la interfaz esperada.)*  

