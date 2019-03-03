package studentInternshipManagerExceptions;

import javax.xml.ws.WebFault;

@WebFault (name="InvalidEmailException", targetNamespace="http://localhost:8080/SIM_WebP/services/SIMImpl")
public class InvalidEmailException extends Exception {

	private static final long serialVersionUID = -6732424747520106682L;
	public String message;
	public Object cause;
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public InvalidEmailException() {
		super();
    }

    public InvalidEmailException(String message) {
        this.message = message;
    }

    public InvalidEmailException(Exception cause) {
        this.cause = cause;
    }

    public InvalidEmailException(String message, Exception cause) {
        this.message = message;
        this.cause = cause;
    }
}
