package componente;

import modosRegistros.BaseDatoLog;
import modosRegistros.FileLog;
import modosRegistros.RegistroStrategy;
import modosRegistros.TerminalLog;
import modosRegistros.basesDatosAdapter.MongoDBAdapter;
import modosRegistros.basesDatosAdapter.MySQLAdapter;

public class LoggerFactory {

  public static Logger create(String modoRegistro, String baseDato) {
    return createInstance(modoRegistro, baseDato);
  }

  public static Logger create(String modoRegistro) {
    return createInstance(modoRegistro, "mysql");
  }

  private static Logger createInstance(String modo, String bd) {
    Logger logger = null;

    switch(modo) {
      case "terminal":
        logger = new Logger(new TerminalLog());
        break;
      case "file":
        logger = new Logger(new FileLog());
        break;
      case "basedato":
        if(bd.equals("mysql"))
          logger = new Logger(new BaseDatoLog(new MySQLAdapter()));
        if(bd.equals("mongo"))
          logger = new Logger(new BaseDatoLog(new MongoDBAdapter()));
        break;
    }

    return logger;
  }

}
