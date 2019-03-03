package studentInternshipManagerExceptions;

import java.io.Serializable;
import java.text.MessageFormat;

public class Response implements Serializable{

	
	private static final long serialVersionUID = -3907022566796580159L;
	public static final Response OK = new Response(1, "SUCCESS");
	public static final Response ERROR_INVALID_NAME = new Response(2, "''{0}'' is not a valid name. Only letters and '-' sign are allowed with length of 1-20 characters");
	public static final Response ERROR_INVALID_EMAIL = new Response(3, "''{0}'' is not a vaild email address!");
	public static final Response ERROR_INVALID_PHONE_NUMBER = new Response(4, "''{0}''  is not a valid phone number! Only numbers are allowed with length of 5-25 digits");
	public static final Response ERROR_INVALID_ID = new Response(5, "Syntax error: ''{0}'' is invalid ID");
	public static final Response ERROR_EMPTY_PARAMETERS = new Response(6, "Please specify all parameters!");
	public static final Response ERROR_INACTIVE_STUDENT_STATUS = new Response(7, "Student is not active");
	


	private int code;
	private String message;
	private Object[] args;

	public Response() {

	}

	public Response(int code, String message) {
		this(code, message, null);
	}

	public Response(int code, String message, Object[] args) {
		this.code = code;
		if (args != null) {
			MessageFormat mf = new MessageFormat(message);
			this.message = mf.format(args);
			this.args = args;
		} else {
			this.message = message;
		}
	}

	public Response fill(Object... args) {
		Response result = new Response(code, message, args);
		return result;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object[] getArgs() {
		return args;
	}
}
