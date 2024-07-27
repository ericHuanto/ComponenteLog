package componente;

import registros.MedioRegistro;

public class Logging {
  private MedioRegistro medioRegistro;

  public Logging() {}

  public void registrar(ErrorLog error) {
    medioRegistro.registrar(error);
  }
  
}
