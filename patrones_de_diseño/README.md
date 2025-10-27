### Para el Requerimiento 1 (Motor de Renderizado):
- ¿Qué patrón de diseño creacional eligieron?
- ¿Por qué este patrón es la solución adecuada para este problema?
- ¿Qué problema(s) evita (ej. acoplamiento, violación del principio Abierto/Cerrado)?
  
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
- ¿Por qué este patrón es la solución adecuada para este
requerimiento?
- ¿Cómo garantizaron la unicidad de la instancia? 
