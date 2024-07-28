package registros.tipoRegistros.basesDeDatos;

import componente.ErrorLog;

public interface BaseDatoAdapter {
  void coneccion();
  void insert(String errorLog, ErrorLog error);
  void desconeccion();
}
