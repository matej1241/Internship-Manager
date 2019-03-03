package studentInternshipManager;

import javax.jws.WebService;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import studentInternshipManagerExceptions.InvalidEmailException;
import studentInternshipManagerExceptions.InvalidNameException;
import studentInternshipManagerExceptions.InvalidPhoneNumberException;
import studentInternshipManagerExceptions.Response;

@WebService(name="StudentInternshipManager", targetNamespace="http://localhost:8080/SIM_WebP/services/SIMImpl", endpointInterface="studentInternshipManager.SIMInterface")
@SOAPBinding(style=Style.RPC, use=Use.ENCODED)
public interface SIMInterface {
	
	@WebMethod
	public 	Object createUser(
			@WebParam (name="userID") String userID,
			@WebParam (name="password") String password,
			@WebParam (name="name") String name,
			@WebParam (name="surname") String surname,
			@WebParam (name="businessMobile") String businessMobile,
			@WebParam (name="privateMobile") String privateMobile, 
			@WebParam (name="businessMail") String businessMail,
			@WebParam (name="privateMail") String privateMail,
			@WebParam (name="role") String role) 
					throws InvalidNameException, InvalidEmailException, InvalidPhoneNumberException;
	
	@WebMethod
	public Response createTextLog(
			@WebParam (name="userID") String userID,
			@WebParam (name="text") String text, 
			@WebParam (name="startTime") Date startTime,
			@WebParam (name="endTime") Date endTime);
	
	@WebMethod
	public Response submitTextLog(
			@WebParam (name="userID") String userID,
			@WebParam (name="logID") String logID);
	
	@WebMethod
	public Response unlockTextLog(
			@WebParam (name="userID") String userID,
			@WebParam (name="logID") String logID);
	
	@WebMethod
	public Response assignUser(
			@WebParam (name="mentorID") String mentorID,
			@WebParam (name="studentID") String studentID);
	
	@WebMethod
	public @WebResult (name="assignedList", partName="assignedList", targetNamespace="http://localhost:8080/SIM_WebP/services/UsersImpl") UserInformation[] viewAssignedList(
			@WebParam (name="userID") String userID);
	
	@WebMethod
	public Response editInfo(
			@WebParam (name="userID") String userID,
			@WebParam (name="businessMobile") String businessMobile,
			@WebParam (name="privateMobile") String privateMobile,
			@WebParam (name="businessMail") String businessMail,
			@WebParam (name="privateMail") String privateMail);
	
	@WebMethod
	public @WebResult (name="logInformationList", partName="logInformationList", targetNamespace="http://localhost:8080/SIM_WebP/services/UsersImpl") LogInformation[] viewStudentLogs(
			@WebParam (name="userID") String userID);
	
	@WebMethod
	public Response disableStudent(
			@WebParam (name="userID") String userID);
	
	@WebMethod
	public Response enableStudent(
			@WebParam (name="userID") String userID);
	
	@WebMethod
	public Response commentStudent(
			@WebParam (name="studentID") String studentID,
			@WebParam (name="publicComment") String publicComment,
			@WebParam (name="internalComment") String internalComment);
	
	@WebMethod
	public Object viewPersonalInfo(
			@WebParam (name="userID") String userID);
	
	@WebMethod
	public Object editTextLog(
			@WebParam (name="userID") String userID,
			@WebParam (name="logID") String logID,
			@WebParam (name="logText") String text);
	//*editTextLog
	//*viewPersonalInfo
}
