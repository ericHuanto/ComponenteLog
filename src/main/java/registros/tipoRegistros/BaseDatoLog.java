package registros.tipoRegistros;

import componente.ErrorLog;
import registros.RegistroStrategy;
import registros.tipoRegistros.basesDeDatos.BaseDatoAdapter;

public class BaseDatoLog implements RegistroStrategy {
  private BaseDatoAdapter baseDato;

  public BaseDatoLog(BaseDatoAdapter baseDato) {
    this.baseDato = baseDato;
  }

  @Override
  public void registrar(ErrorLog error) {

  }
}
