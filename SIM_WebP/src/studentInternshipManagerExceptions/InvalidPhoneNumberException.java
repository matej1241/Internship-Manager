package studentInternshipManagerExceptions;

import javax.xml.ws.WebFault;

@WebFault (name="InvalidPhoneNumberException", targetNamespace="http://localhost:8080/SIM_WebP/services/SIMImpl")
public class InvalidPhoneNumberException extends Exception {

	private static final long serialVersionUID = -6867431410986193278L;
	public String message;
	public Object cause;
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public InvalidPhoneNumberException() {
		super();
    }

    public InvalidPhoneNumberException(String message) {
        this.message = message;
    }

    public InvalidPhoneNumberException(Exception cause) {
        this.cause = cause;
    }

    public InvalidPhoneNumberException(String message, Exception cause) {
    	this.message = message;
        this.cause = cause;
    }
}
