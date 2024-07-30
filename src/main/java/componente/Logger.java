package componente;

import lombok.Getter;
import lombok.Setter;
import modosRegistros.BaseDatoLog;
import modosRegistros.RegistroStrategy;
import modosRegistros.basesDatosAdapter.DataBaseAdapter;

@Getter
@Setter
public class Logger {
  private RegistroStrategy modoRegistro;

  public Logger(RegistroStrategy modoRegistro) {
    this.modoRegistro = modoRegistro;
  }

  public void setBaseDato(DataBaseAdapter baseDato) {
    if(modoRegistro instanceof BaseDatoLog)
      ((BaseDatoLog) modoRegistro).setBaseDato(baseDato);
  }

  public void registrar(ErrorLog error) throws Exception {
    modoRegistro.registrar(error);
  }

}
