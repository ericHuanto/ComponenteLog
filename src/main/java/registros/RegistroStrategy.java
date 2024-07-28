package registros;

import componente.ErrorLog;

public interface RegistroStrategy {

  void registrar(ErrorLog error);

}
