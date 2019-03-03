package studentInternshipManagerExceptions;

import javax.xml.ws.WebFault;

@WebFault (name="InvalidUserIDException", targetNamespace="http://localhost:8080/SIM_WebP/services/SIMImpl")
public class InvalidUserIDException extends Exception {

  private static final long serialVersionUID = -5062778683393491316L;

  public String message;
  public Object cause;
  
  @Override
  public String getMessage() {
    return message;
  }
  
  public InvalidUserIDException() {
    super();
    }

    public InvalidUserIDException(String message) {
        this.message = message;
    }

    public InvalidUserIDException(Exception cause) {
        this.cause = cause;
    }

    public InvalidUserIDException(String message, Exception cause) {
        this.message = message;
        this.cause = cause;
    }
  
}
