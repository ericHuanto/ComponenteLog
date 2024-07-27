package componente;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ErrorLog {
  private String mensaje;
  private LocalDateTime fechaHora;
  private String tracktrace;

  public ErrorLog(String mensaje, LocalDateTime fechaHora, String tracktrace) {
    this.mensaje = mensaje;
    this.fechaHora = fechaHora;
    this.tracktrace = tracktrace;
  }

}
