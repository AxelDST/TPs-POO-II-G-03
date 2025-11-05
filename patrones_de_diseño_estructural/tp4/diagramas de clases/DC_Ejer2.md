classDiagram
  direction LR

  class GeneradorReporteFiscalFacade {
    - db : ConectorDB
    - lector : LectorDeDatos
    - afip : ServicioWebAFIP
    - proc : ProcesadorDeImpuestos
    - pdf : RenderizadorPDF
    + generarPDF(idCliente: int) Path
  }

  class ConectorDB {
    + conectar()
    + desconectar()
  }

  class LectorDeDatos {
    + obtenerDatosCliente(idCliente: int) Map<String,String>
  }

  class ServicioWebAFIP {
    + obtenerDatosFiscales(cuit: String) Map<String,Object>
  }

  class ProcesadorDeImpuestos {
    + calcularTotal(datosCliente: Map<String,String>, datosAfip: Map<String,Object>) double
  }

  class RenderizadorPDF {
    + renderizar(titulo: String, cuerpo: String) Path
  }

  GeneradorReporteFiscalFacade --> ConectorDB
  GeneradorReporteFiscalFacade --> LectorDeDatos
  GeneradorReporteFiscalFacade --> ServicioWebAFIP
  GeneradorReporteFiscalFacade --> ProcesadorDeImpuestos
  GeneradorReporteFiscalFacade --> RenderizadorPDF
