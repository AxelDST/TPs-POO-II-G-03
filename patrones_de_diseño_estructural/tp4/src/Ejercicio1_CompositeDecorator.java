// Demostración del uso de Composite + Decorator (versión simplificada)
public class Ejercicio1_CompositeDecorator {
    public static void main(String[] args) {
        System.out.println("=== ESCENARIO 1: ENSAMBLAJE DE COMPUTADORAS ===\n");
        
        // Crear componentes individuales usando la clase genérica ComponenteSimple
        ComponentePC cpu = new ComponenteSimple("CPU", "Intel i7-12700K", 45000);
        ComponentePC ram = new ComponenteSimple("RAM", "16GB DDR4", 12000);
        ComponentePC ssd = new ComponenteSimple("SSD", "1TB NVMe", 18000);
        ComponentePC placa = new ComponenteSimple("Placa Madre", "ASUS ROG Strix", 28000);
        
        // Crear gabinete (composite) y agregar componentes
        Gabinete pc = new Gabinete("NZXT H510", 15000);
        pc.agregarComponente(cpu);
        pc.agregarComponente(ram);
        pc.agregarComponente(ssd);
        pc.agregarComponente(placa);
        
        System.out.println("--- PC Base ---");
        pc.mostrarDetalle("");
        System.out.println("Precio total: $" + pc.obtenerPrecio());
        System.out.println();
        
        // Aplicar decorador: agregar garantía extendida
        ComponentePC pcConGarantia = new DecoradorServicio(pc, "Garantía Extendida 12 meses", 6000);
        System.out.println("--- PC con Garantía Extendida ---");
        pcConGarantia.mostrarDetalle("");
        System.out.println("Precio total: $" + pcConGarantia.obtenerPrecio());
        System.out.println();
        
        // Aplicar múltiples decoradores: garantía + instalación
        ComponentePC pcCompleta = new DecoradorServicio(
            new DecoradorServicio(pc, "Garantía Extendida 24 meses", 12000), 
            "Servicio de Instalación", 8000
        );
        System.out.println("--- PC con Garantía + Instalación ---");
        pcCompleta.mostrarDetalle("");
        System.out.println("Precio total: $" + pcCompleta.obtenerPrecio());
        System.out.println();
        
        // Ejemplo: Componente individual decorado
        System.out.println("--- CPU Individual con Garantía ---");
        ComponentePC cpuConGarantia = new DecoradorServicio(cpu, "Garantía 6 meses", 1800);
        cpuConGarantia.mostrarDetalle("");
        System.out.println("Precio total: $" + cpuConGarantia.obtenerPrecio());
    }
}
