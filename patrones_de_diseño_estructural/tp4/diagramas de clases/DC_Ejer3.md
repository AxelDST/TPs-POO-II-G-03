classDiagram

class IServicioEnvio {
  <<interface>>
  +float calcularCosto(codigoPostal: String)
  +String obtenerTiempoEstimado(codigoPostal: String)
  +String despacharPedido(direccion: String, codigoPostal: String, idPedido: String)
}

class LogisticaVelozAdapter {
  -api: ApiLogisticaVeloz
  -toIntCP(codigoPostal: String) int
  +float calcularCosto(codigoPostal: String)
  +String obtenerTiempoEstimado(codigoPostal: String)
  +String despacharPedido(direccion: String, codigoPostal: String, idPedido: String)
}

class ApiLogisticaVeloz {
  +Cotizacion cotizarEnvio(cpDestino: int)
  +String enviarPaquete(datos: DatosEnvio)
}

class Cotizacion {
  -costo: float
  -dias: int
  +getCosto() float
  +getDias() int
}

class DatosEnvio {
  +direccion: String
  +codigoPostal: int
  +idPedido: String
}

class SistemaDeEnvios {
  +main(args: String[])
}

IServicioEnvio <|.. LogisticaVelozAdapter : implements
LogisticaVelozAdapter *-- ApiLogisticaVeloz : compone
ApiLogisticaVeloz ..> Cotizacion : devuelve
ApiLogisticaVeloz ..> DatosEnvio : recibe
SistemaDeEnvios ..> IServicioEnvio : usa