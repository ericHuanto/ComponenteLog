package componente;

import modosRegistros.RegistroStrategy;

public class Logger {
  private RegistroStrategy medioRegistro;

  public Logger(RegistroStrategy medioRegistro) {
    this.medioRegistro = medioRegistro;
  }

  public void registrar(ErrorLog error) throws Exception {
    medioRegistro.registrar(error);
  }

  public void setMedioRegistro(RegistroStrategy medioRegistro) {
    this.medioRegistro = medioRegistro;
  }
}
