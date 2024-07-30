package modosRegistros.basesDatosAdapter;

import BaseDatos.MongoDBConnect;
import BaseDatos.MySQLConnect;
import BaseDatos.configuraciones.ConfigProperties;
import componente.ErrorLog;
import java.lang.reflect.Field;
import java.sql.SQLException;

public class MySQLAdapter implements DataBaseAdapter{
  private MySQLConnect mySQLConnect;
  private ConfigProperties config;

  public MySQLAdapter() {
    this.mySQLConnect = new MySQLConnect();
    this.config = new ConfigProperties();
  }

  @Override
  public void coneccion() {
    try {
      this.mySQLConnect.connect(
          this.config.getProperty("mySQLurlConnection"),
          this.config.getProperty("mySQLusername"),
          this.config.getProperty("mySQLpassword")
      );
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public void inserccion(String errorLog, ErrorLog error) throws Exception {
    Field[] fields = Error.class.getDeclaredFields();

    String[] columnNames = new String[fields.length];
    Object[] values = new Object[fields.length];

    for (int i = 0; i < fields.length; i++) {
      Field field = fields[i];
      try {
        field.setAccessible(true); // Hacer accesible el campo privado
        columnNames[i] = field.getName(); // Guardar el nombre del campo
        values[i] = field.get(error); // Guardar el valor del campo

      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }

    this.mySQLConnect.insert(errorLog, columnNames, values);

  }

  @Override
  public void desconeccion() {
    try {
      this.mySQLConnect.disconnect();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

}
