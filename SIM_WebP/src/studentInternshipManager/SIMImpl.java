package studentInternshipManager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import studentInternshipManagerExceptions.InvalidEmailException;
import studentInternshipManagerExceptions.InvalidNameException;
import studentInternshipManagerExceptions.InvalidPhoneNumberException;
import studentInternshipManagerExceptions.InvalidUserIDException;
import studentInternshipManagerExceptions.Response;

@WebService(targetNamespace="http://localhost:8080/SIM_WebP/services/SIMImpl", endpointInterface="studentInternshipManager.SIMInterface")
public class SIMImpl extends MyConstants implements SIMInterface{
	
	DatabaseCommunication dbcom = new DatabaseCommunication();
	
	@Override
    public Object createUser(
    		@WebParam (name="userID") String userID,
    		@WebParam (name="password") String password,
    		@WebParam (name="name") String name,
    		@WebParam (name="surname") String surname,
    		@WebParam (name="businessMobile") String businessMobile,
    		@WebParam (name="privateMobile") String privateMobile,
    		@WebParam (name="businessMail") String businessMail,
    		@WebParam (name="privateMail") String privateMail,
    		@WebParam (name="role") String role)
    		throws InvalidNameException, InvalidEmailException, InvalidPhoneNumberException 
	{
	  UserInformation userInfo = new UserInformation();
	  	try
	  		{
	  			ParametersCheck.checkParameters(name, surname, businessMobile, privateMobile, businessMail, privateMail);
	  			userInfo = dbcom.createUser(userID, password, name, surname, businessMobile, privateMobile, businessMail, privateMail, role);
	  			return userInfo;	
	  		}
	  	
	  	catch(SQLException e)
	  		{
  			return Response.ERROR_INVALID_ID.fill(e.getMessage());
	  		}
	  	
	  	catch(InvalidNameException e)
	  		{
	  			return Response.ERROR_INVALID_NAME.fill(e.getMessage());
	  		}
	  	
	  	catch(InvalidEmailException e)
	  		{
	  			return Response.ERROR_INVALID_EMAIL.fill(e.getMessage());
	  		}
	  	
	  	catch(InvalidPhoneNumberException e)
	  		{
	  			return Response.ERROR_INVALID_PHONE_NUMBER.fill(e.getMessage());
	  		}  
   }
	  
	@Override
    public Response createTextLog(
    		@WebParam (name="userID") String userID, 
    		@WebParam (name="text") String text,
    		@WebParam (name="startTime") Date startTime, 
    		@WebParam (name="endTime") Date endTime)
	{
		try
	    	{
			if(dbcom.getStudentStatus(userID) == STUDENT_STATUS_ACTIVE)
				{
				if(dbcom.getUserRole(userID) == USER_ROLE_STUDENT)
	        		{
						dbcom.createTextLog(userID, text, startTime, endTime);
						return Response.OK;
	        		}
	      
				else if(dbcom.getUserRole(userID) == USER_ROLE_MENTOR)
	        		{
						throw new InvalidUserIDException(userID);
	        		}
	      
				else
	      			{
						return Response.OK; 
	      			}
				}
			
			else
				{
					return Response.ERROR_INACTIVE_STUDENT_STATUS.fill(dbcom.getUserRole(userID));
				}
	    	}
	  
		catch(InvalidUserIDException e)
	    	{
				return Response.ERROR_INVALID_ID.fill(e.getMessage());
	    	}
		
		//*provjerit velicinu teksta
	}
    
	@Override
    public Response submitTextLog(
    		@WebParam (name="userID") String userID,
    		@WebParam (name="logID") String logID)
	{
		try
			{
			if(dbcom.getUserRole(userID) == USER_ROLE_STUDENT)
				{
				if(dbcom.getStudentStatus(userID) == STUDENT_STATUS_ACTIVE)
					{
						dbcom.submitTextLog(userID, logID);
						return Response.OK;
					}
	    
				else if(dbcom.getUserRole(userID) == USER_ROLE_MENTOR)
					{
					throw new InvalidUserIDException(userID);
					}
			
				else
					{
					return Response.ERROR_INACTIVE_STUDENT_STATUS.fill(userID);
					}
				}
			else
				{
					throw new InvalidUserIDException(userID);
				}
			}
	  
		catch(InvalidUserIDException e)
			{
				return Response.ERROR_INVALID_ID.fill(e.getMessage());
			}
		
		//*napraviti provjeru za logID
	  
	}
	
	@Override
	public Response unlockTextLog(
			@WebParam (name="userID") String userID,
			@WebParam (name="logID") String logID)
	{
		try
			{
				if(dbcom.getUserRole(userID) == USER_ROLE_STUDENT)
				{
					dbcom.unlockTextLog(userID, logID);
					return Response.OK;
				}
    
				else if(dbcom.getUserRole(userID) == USER_ROLE_MENTOR)
				{
					throw new InvalidUserIDException(userID);
				}
		
				else
				{
					return Response.ERROR_INVALID_ID.fill(userID);
				}
			}
		
		catch(InvalidUserIDException e)
		{
			return Response.ERROR_INVALID_ID.fill(e.getMessage());
		}
	}
   
	@Override
    public Response assignUser( 
    		@WebParam (name="mentorID") String mentorID, 
    		@WebParam (name="studentID") String studentID)
	{
		try
			{
			if(dbcom.getUserRole(mentorID) == USER_ROLE_MENTOR)
				{
				if (dbcom.getUserRole(studentID) == USER_ROLE_STUDENT)
	            	{
						dbcom.assignUser(mentorID, studentID);
						return Response.OK;
	            	}
				else 
	            	{
						throw new InvalidUserIDException(studentID);
	            	}
				}
	      
			else 
	        	{
					return Response.ERROR_INVALID_ID.fill(mentorID);
	        	}
			}
		
		catch(InvalidUserIDException e)
			{
				return Response.ERROR_INVALID_ID.fill(e.getMessage());
			}

	}
	
	@Override
    public UserInformation[] viewAssignedList(
    		@WebParam (name="userID") String userID)
	{
		List<LogInformation> list = new ArrayList<LogInformation>();
	
			if(dbcom.getUserRole(userID) == USER_ROLE_MENTOR)
	        	{
					return dbcom.viewMentorAssignedList(userID);
	        	}
  
			else if(dbcom.getUserRole(userID) == USER_ROLE_STUDENT)
	        	{
					return dbcom.viewStudentAssignedList(userID);
	        	}
			
			else
				{
					return list.toArray(new UserInformation[0]);
				}

		


	}
	
    @Override
    public Response editInfo(
    		@WebParam (name="userID") String userID,
    		@WebParam (name="businessMobile") String businessMobile,
    		@WebParam (name="privateMobile") String privateMobile,
    		@WebParam (name="businessMail") String businessMail,
    		@WebParam (name="privateMail") String privateMail)
    {
    	try
    		{
    			if(businessMobile != null)
    				{
    					ParametersCheck.checkPhoneNumber(businessMobile);
    				}
    		
    			if(privateMobile != null)
					{
    					ParametersCheck.checkPhoneNumber(privateMobile);
					}
    			
    			if(businessMail != null)
    				{
    					ParametersCheck.checkEmail(businessMail);
    				}
    			
    			if(privateMail != null)
    				{
    					ParametersCheck.checkEmail(privateMail);
    				}
    			
    			
    			dbcom.editInfo(userID, businessMobile, privateMobile, businessMail, privateMail);
    			return Response.OK;
    		}
    	
  	
    	catch(InvalidEmailException e)
  			{
  				return Response.ERROR_INVALID_EMAIL.fill(e.getMessage());
  			}
  	
    	catch(InvalidPhoneNumberException e)
  			{
  				return Response.ERROR_INVALID_PHONE_NUMBER.fill(e.getMessage());
  			}  

    }
    
    @Override
    public LogInformation[] viewStudentLogs(
    		@WebParam (name="userID") String userID)
    {
    	List<LogInformation> list = new ArrayList<LogInformation>();
    	try
        	{
    			if(dbcom.getUserRole(userID) == USER_ROLE_STUDENT)
    				{
    					return dbcom.viewStudentLogs(userID);
    				}
          
    			else if(dbcom.getUserRole(userID) == USER_ROLE_MENTOR)
    				{
    					throw new InvalidUserIDException(userID);
    				}
          
    			else
    				{
    					return list.toArray(new LogInformation[0]);
    				}
        	}
      
      catch(InvalidUserIDException e)
    	{
    	  return list.toArray(new LogInformation[0]);
    	}
          
    }
    
    @Override
    public Response disableStudent(
    		@WebParam (name="userID") String userID)
    {
      try
      	{
    	  if(dbcom.getUserRole(userID) == USER_ROLE_STUDENT)
          	{
    		  dbcom.disableStudent(userID);
    		  return Response.OK;
          	}
        
    	  else
          	{
    		  throw new InvalidUserIDException(userID);
          	}
      	}
      
      catch(InvalidUserIDException e)
      	{
    	  return Response.ERROR_INVALID_ID.fill(userID);
      	}
      
    }
    
    @Override
    public Response enableStudent(
    		@WebParam (name="userID") String userID)
    {
        try
      	{
    	  if(dbcom.getUserRole(userID) == USER_ROLE_STUDENT)
          	{
    		  dbcom.enableStudent(userID);
    		  return Response.OK;
          	}
        
    	  else
          	{
    		  throw new InvalidUserIDException(userID);
          	}
      	}
      
      catch(InvalidUserIDException e)
      	{
    	  return Response.ERROR_INVALID_ID.fill(e.getMessage());
      	}
      
    }
    
    @Override
    public Response commentStudent(
			@WebParam (name="studentID") String studentID,
			@WebParam (name="publicComment") String publicComment,
			@WebParam (name="internalComment") String internalComment)
    {
    	try
    	{
    		if(dbcom.getUserRole(studentID) == USER_ROLE_STUDENT)
    			{
    				dbcom.commentStudent(studentID, publicComment, internalComment);
    				return Response.OK;
    			}
    		
    		else 
    			{
    				throw new InvalidUserIDException(studentID);
    			}
    	}
    	
    	catch(InvalidUserIDException e)
    		{
    			return Response.ERROR_INVALID_ID.fill(studentID);
    		}
    }
    
    @Override
    public Object viewPersonalInfo(
			@WebParam (name="userID") String userID)
    {
    	try
    	{
    		if(dbcom.getUserRole(userID) == USER_ROLE_STUDENT)
    		{
    			if(dbcom.getStudentStatus(userID) == STUDENT_STATUS_ACTIVE)
    			{
    				return dbcom.viewPersonalInfo(userID);
    			}
    			
    			else
    			{
    				throw new InvalidUserIDException(userID);
    			}
    		}
    		
    		else if (dbcom.getUserRole(userID) == USER_ROLE_MENTOR)
    		{
    			return dbcom.viewPersonalInfo(userID);
    		}
    		
    		else
    		{
    			throw new InvalidUserIDException(userID);
    		}
    	}
    	
    	catch(InvalidUserIDException e)
		{
			return Response.ERROR_INVALID_ID.fill(userID);
		}
    }
    
    @Override
    public Object editTextLog(
			@WebParam (name="userID") String userID,
			@WebParam (name="logID") String logID,
			@WebParam (name="logText") String text)
    {
    	try
    	{
    		if(dbcom.getUserRole(userID) == USER_ROLE_STUDENT)
    		{
    			if(dbcom.getLogStatus(logID) == LOG_STATUS_UNLOCKED)
    			{
    				dbcom.editTextLog(logID, text);
    				return Response.OK;
    			}
    			
    			else
    			{
    				return Response.ERROR_INVALID_ID;
    			}
    		}
    		
    		else
    		{
    			throw new InvalidUserIDException(userID);
    		}
    	}
    	
    	catch(InvalidUserIDException e)
		{
			return Response.ERROR_INVALID_ID.fill(userID);
		}
    }
}
