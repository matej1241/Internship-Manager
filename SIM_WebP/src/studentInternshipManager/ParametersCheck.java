package studentInternshipManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import studentInternshipManagerExceptions.InvalidEmailException;
import studentInternshipManagerExceptions.InvalidNameException;
import studentInternshipManagerExceptions.InvalidPhoneNumberException;

public class ParametersCheck{
	
	public static void checkParameters (String name, String surname, String businessMobile, String privateMobile, String businessMail, String privateMail)
			throws InvalidNameException, InvalidEmailException, InvalidPhoneNumberException {

		String mailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z-9]+\\.)+[a-zA-Z]{2,}))$";
		String nameRegex = "^{1,20}(((?!\\s*$))([a-zA-Z\\- ])+?){1,20}$";
		String mobileRegex = "^(?=.{5,25})((\\+?)([0-9 ])+?){5,25}$";
		
		Pattern mailPattern = Pattern.compile(mailRegex);
		Pattern namePattern = Pattern.compile(nameRegex);
		Pattern mobilePattern = Pattern.compile(mobileRegex);
		
		Matcher businessMailMatcher = mailPattern.matcher(businessMail);
		Matcher privateMailMatcher = mailPattern.matcher(privateMail);
		Matcher nameMatcher = namePattern.matcher(name);
		Matcher surnameMatcher = namePattern.matcher(surname);
		Matcher businessMobileMatcher = mobilePattern.matcher(businessMobile);
		Matcher privateMobileMatcher = mobilePattern.matcher(privateMobile);
		
		if(!nameMatcher.matches()){
			throw (new InvalidNameException(name));
		}
		if(!surnameMatcher.matches()){
			throw (new InvalidNameException(surname));
		}
		if(!businessMobileMatcher.matches()){
			throw (new InvalidPhoneNumberException(businessMobile));
		}
		if(!privateMobileMatcher.matches()){
			throw (new InvalidPhoneNumberException(privateMobile));
		}
		if(!businessMailMatcher.matches()){
			throw (new InvalidEmailException(businessMail));
		}
		if(!privateMailMatcher.matches()){
			throw (new InvalidEmailException(privateMail));
		}

	}
	
	public static void checkPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException
	{
		String phoneRegex = "^(?=.{5,25})((\\+?)([0-9 ])+?){5,25}$";
		Pattern phonePattern = Pattern.compile(phoneRegex);
		Matcher phoneMatcher = phonePattern.matcher(phoneNumber);
		
		if(!phoneMatcher.matches())
			{
				throw (new InvalidPhoneNumberException(phoneNumber));
			}
	}
	
	public static void checkEmail(String email) throws InvalidEmailException
	{
		String mailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z-9]+\\.)+[a-zA-Z]{2,}))$";
		Pattern mailPattern = Pattern.compile(mailRegex);
		Matcher mailMatcher = mailPattern.matcher(email);
		
		if(!mailMatcher.matches())
			{
				throw(new InvalidEmailException(email));
			}
	}
	
	public static void checkName(String name) throws InvalidNameException
	{
		String nameRegex = "^{1,20}(((?!\\s*$))([a-zA-Z\\- ])+?){1,20}$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		
		if(!nameMatcher.matches())
			{
				throw new InvalidNameException(name);
			}
	}
	
	
}
