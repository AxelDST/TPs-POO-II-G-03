### Para el Requerimiento 1 (Motor de Renderizado):
- ¿Qué patrón de diseño creacional eligieron?
  - Para el requerimiento 1 se eligió el patrón de diseño Abstract Factory.

- ¿Por qué este patrón es la solución adecuada para este problema?
  - Este patrón es el adecuado porque el sistema necesita crear objetos de renderizado en distintos formatos (PDF, Excel, CSV) sin que el cliente conozca ni dependa de las clases concretas que los implementan.
  El patrón Abstract Factory permite definir una interfaz para crear familias de objetos relacionados sin especificar sus clases concretas. De esta manera, se logra un bajo acoplamiento entre el cliente y las implementaciones, y el sistema queda abierto a la extensión (por ejemplo, agregar un nuevo formato como XML) sin necesidad de modificar el código existente.

- ¿Qué problema(s) evita (ej. acoplamiento, violación del principio Abierto/Cerrado)?
  - Evita el acoplamiento del código cliente con clases concretas como RenderizadorPDF o RenderizadorExcel, promoviendo la dependencia de abstracciones.

  - Cumple con el principio Abierto/Cerrado (OCP): nuevos formatos pueden añadirse extendiendo la fábrica, sin alterar el código cliente existente.

  - Previene duplicación de lógica de creación, centralizando la responsabilidad de instanciación en un único punto (la fábrica).

  - Evita errores de compatibilidad entre objetos relacionados (por ejemplo, un renderizador PDF asociado a un formato incorrecto).

  
### Para el Requerimiento 2 (Construcción de Reportes):
- **¿Qué patrón de diseño creacional eligieron?**
    Para el requerimiento 2 se elegió el patrón de diseño **Builder**

- **¿Por qué este patrón es la solución adecuada?**
    Este patrón es el adecuado debido a que el requerimiento específica la necesidad de definir múltiples parámetros, siendo algunos de estos opcionales, el patrón de diseño Builder se encarga de construir un objeto paso a paso, seleccionando aquellas características deseadas para el mismo, muy útil cuando se tiene un objeto con múltiples parámetros siendo la mayoría de ellos opcionales.
- **¿Qué problemas específicos del "constructor" resuelve?**
    Resuelve los dos problemas exactos que el requerimiento busca evitar
    1. Elimina la necesidad de tener múltiples constructores con diferentes combinaciones de parámetros
    2. Libera al cliente de la obligación de pasar null para los valores opcionales que no desea especificar, lo cual es propenso a errores y difícil de leer
  

### Para el Requerimiento 3 (Gestor de Configuración):
- ¿Qué patrón de diseño creacional eligieron?
  Se eligió el patrón **Singleton**.

- ¿Por qué este patrón es la solución adecuada para este requerimiento?
  Porque el requerimiento 3 exige explícitamente que solo exista "una y solo una instancia del objeto GestorConfiguracion" y que haya un "único punto de acceso". El patrón Singleton está diseñado específicamente para cumplir con estos dos requisitos, evitando ineficiencias e inconsistencias de datos.

- ¿Cómo garantizaron la unicidad de la instancia? 
  La unicidad de la instancia se garantiza mediante tres mecanismos clave en el código Java:
    1.  **Constructor Privado (`private GestorConfiguracion()`):** Esto prohíbe que cualquier otra clase pueda crear una instancia usando el operador `new`.
    2.  **Instancia Estática Privada (`private static final GestorConfiguracion instancia ...`):** La clase misma crea y almacena su propia instancia única en una variable estática.
    3.  **Método Público Estático (`public static GestorConfiguracion getInstance()`):** Este es el "único punto de acceso". Es el único método que puede devolver la instancia única almacenada.
