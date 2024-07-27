package registros.tipoRegistros;

import componente.ErrorLog;
import java.time.format.DateTimeFormatter;
import registros.MedioRegistro;

public class TerminalLog implements MedioRegistro {

  @Override
  public void registrar(ErrorLog error) {
    System.out.println("Mensaje: " + error.getMensaje() +
                       "Fecha: " + error.getFechaHora().format(DateTimeFormatter.BASIC_ISO_DATE) +
                       "tracktrace: " + error.getTracktrace());
  }

}
