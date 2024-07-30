package modosRegistros;

import componente.ErrorLog;

public interface RegistroStrategy {

  void registrar(ErrorLog error) throws Exception;

}
