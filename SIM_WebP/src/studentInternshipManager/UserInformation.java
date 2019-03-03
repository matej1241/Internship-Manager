package studentInternshipManager;

import java.io.Serializable;

public class UserInformation implements Serializable{
    

	private static final long serialVersionUID = 8794995738726159892L;
	public String userID;
	public String name;
	public String surname;
	public String password;
	public String businessMail;
	public String privateMail;
	public String businessMobile;
	public String privateMobile;
    public String role;
    
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserInformation() {
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBusinessMail() {
		return businessMail;
	}

	public void setBusinessMail(String businessMail) {
		this.businessMail = businessMail;
	}

	public String getPrivateMail() {
		return privateMail;
	}

	public void setPrivateMail(String privateMail) {
		this.privateMail = privateMail;
	}

	public String getBusinessMobile() {
		return businessMobile;
	}

	public void setBusinessMobile(String businessMobile) {
		this.businessMobile = businessMobile;
	}

	public String getPrivateMobile() {
		return privateMobile;
	}

	public void setPrivateMobile(String privateMobile) {
		this.privateMobile = privateMobile;
	}

}