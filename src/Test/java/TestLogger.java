import componente.ErrorLog;
import componente.Logger;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.WeakHashMap;
import modosRegistros.BaseDatoLog;
import modosRegistros.TerminalLog;
import modosRegistros.basesDatosAdapter.DataBaseAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class TestLogger {
  ErrorLog erro1;
  ErrorLog error2;

  @BeforeEach
  public void inicializacion() {
    erro1 = new ErrorLog("error al parcear un archivo inexistente o protejido", LocalDateTime.now(),"Division.java line 815" );
    error2 = new ErrorLog("An arithmetic error occurred when dividing by zero.", LocalDateTime.now(), "Division.java line 815");
  }

  @Test
  public void logear_usando_la_terminal() throws Exception {
    Logger logger = new Logger(new TerminalLog());

    //redirigimos el output
    ByteArrayOutputStream salida = new ByteArrayOutputStream();
    System.setOut(new PrintStream(salida));

    logger.registrar(erro1);

    Assertions.assertTrue(salida.toString().contains("error al parcear un archivo"));
    //volvemos a como estaba antes
    System.setOut(System.out);
  }

  @Test
  public void loggear_usando_la_base_de_datos() throws Exception {
    DataBaseAdapter baseDatoMockeada = mock(DataBaseAdapter.class);
    Logger logger = new Logger(new BaseDatoLog( baseDatoMockeada ));

    logger.registrar(error2);

    //verify(baseDatoMockeada).coneccion();
    //verify(baseDatoMockeada).inserccion("error_log", error2);
    //verify(baseDatoMockeada).desconeccion();
  }

}
