package modosRegistros.basesDatosAdapter;

import BaseDatos.MongoDBConnect;
import BaseDatos.configuraciones.ConfigProperties;
import componente.ErrorLog;
import java.lang.reflect.Field;
import java.util.Map;
import org.bson.Document;

public class MongoDBAdapter implements DataBaseAdapter{
  private MongoDBConnect mongoDBConnect;
  private ConfigProperties config;

  public MongoDBAdapter() {
    this.mongoDBConnect = new MongoDBConnect();
    this.config = new ConfigProperties();
  }

  @Override
  public void coneccion() {
    this.mongoDBConnect.connect(this.config.getProperty("mongoConnectionString"), this.config.getProperty("mongoDatabaseName"));
  }

  @Override
  public void inserccion(String errorLog, ErrorLog error) {
    Field[] fields = Error.class.getDeclaredFields();

    Document document = new Document();

    for (Field field : fields) {
      try {
        // Hacer accesible el campo privado
        field.setAccessible(true);
        // Agregar el campo al Document
        document.append(field.getName(), field.get(error));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }

    this.mongoDBConnect.insert(errorLog, document);
  }

  @Override
  public void desconeccion() {
    this.mongoDBConnect.disconnect();
  }
}
