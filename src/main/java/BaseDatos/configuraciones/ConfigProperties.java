package BaseDatos.configuraciones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
  private Properties properties;

  public ConfigProperties(/*String filePath*/) {
    this.properties = new Properties();

    try (InputStream input = getClass().getClassLoader().getResourceAsStream("loggerconfig.properties")) {
      if (input == null) {
        throw new FileNotFoundException("Archivo de propiedades no encontrado: " + "loggerconfig.properties");
      }
      properties.load(input);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

}
