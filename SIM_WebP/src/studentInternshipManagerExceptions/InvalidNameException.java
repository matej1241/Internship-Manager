package studentInternshipManagerExceptions;

import javax.xml.ws.WebFault;

@WebFault (name="InvalidNameException", targetNamespace="http://localhost:8080/SIM_WebP/services/SIMImpl")
public class InvalidNameException extends Exception {

	private static final long serialVersionUID = -6372630210207330342L;
	public String message;
	public Object cause;
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public InvalidNameException() {
		super();
    }

    public InvalidNameException(String message) {
        this.message = message;
    }

    public InvalidNameException(Exception cause) {
        this.cause = cause;
    }

    public InvalidNameException(String message, Exception cause) {
        this.message = message;
        this.cause = cause;
    }
}
