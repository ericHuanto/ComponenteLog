package modosRegistros.basesDatosAdapter;

import componente.ErrorLog;

public interface DataBaseAdapter {
  void coneccion();
  void inserccion(String errorLog, ErrorLog error) throws Exception;
  void desconeccion();
}
