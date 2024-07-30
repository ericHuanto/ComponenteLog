package modosRegistros;

import modosRegistros.basesDatosAdapter.DataBaseAdapter;
import componente.ErrorLog;

public class BaseDatoLog implements RegistroStrategy {
  private DataBaseAdapter baseDato;

  public BaseDatoLog(DataBaseAdapter baseDato) {
    this.baseDato = baseDato;
  }

  @Override
  public void registrar(ErrorLog error) throws Exception {
    this.baseDato.coneccion();

    this.baseDato.inserccion("error_log", error);

    this.baseDato.desconeccion();
  }
}
