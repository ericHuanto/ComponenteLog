package modosRegistros;

import componente.ErrorLog;
import java.time.format.DateTimeFormatter;
import modosRegistros.RegistroStrategy;

public class TerminalLog implements RegistroStrategy {

  public TerminalLog() {}

  @Override
  public void registrar(ErrorLog error) {
    System.out.println("Mensaje: " + error.getMensaje() +
                       "Fecha: " + error.getFechaHora().format(DateTimeFormatter.BASIC_ISO_DATE) +
                       "tracktrace: " + error.getTracktrace());
  }

}
