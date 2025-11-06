classDiagram

class ComponentePC {
  <<interface>>
  +double obtenerPrecio()
  +void mostrarDetalle(String indent)
}

class ComponenteSimple {
  -tipo: String
  -descripcion: String
  -precio: double
  +ComponenteSimple(tipo: String, descripcion: String, precio: double)
  +double obtenerPrecio()
  +void mostrarDetalle(String indent)
}

class Gabinete {
  -modelo: String
  -precioBase: double
  -componentes: List~ComponentePC~
  +Gabinete(modelo: String, precioBase: double)
  +void agregarComponente(ComponentePC componente)
  +void removerComponente(ComponentePC componente)
  +double obtenerPrecio()
  +void mostrarDetalle(String indent)
}

class DecoradorComponentePC {
  <<abstract>>
  #componenteDecorado: ComponentePC
  +DecoradorComponentePC(componente: ComponentePC)
  +double obtenerPrecio()
  +void mostrarDetalle(String indent)
}

class DecoradorServicio {
  -tipoServicio: String
  -costoAdicional: double
  +DecoradorServicio(componente: ComponentePC, tipoServicio: String, costoAdicional: double)
  +double obtenerPrecio()
  +void mostrarDetalle(String indent)
}

class Ejercicio1_CompositeDecorator {
  +main(args: String[])
}

%% Patrón Composite
ComponentePC <|.. ComponenteSimple : implements
ComponentePC <|.. Gabinete : implements
Gabinete o-- ComponentePC : contiene

%% Patrón Decorator
ComponentePC <|.. DecoradorComponentePC : implements
DecoradorComponentePC <|-- DecoradorServicio : extends
DecoradorComponentePC o-- ComponentePC : decora

%% Uso
Ejercicio1_CompositeDecorator ..> ComponentePC : usa