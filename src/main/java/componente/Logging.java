package componente;

import registros.RegistroStrategy;

public class Logging {
  private RegistroStrategy registroStrategy;

  public Logging() {}

  public void registrar(ErrorLog error) {
    registroStrategy.registrar(error);
  }
  
}
