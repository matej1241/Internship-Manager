package studentInternshipManager;

public class UsersImplProxy implements studentInternshipManager.UsersImpl {
  private String _endpoint = null;
  private studentInternshipManager.UsersImpl usersImpl = null;
  
  public UsersImplProxy() {
    _initUsersImplProxy();
  }
  
  public UsersImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initUsersImplProxy();
  }
  
  private void _initUsersImplProxy() {
    try {
      usersImpl = (new studentInternshipManager.UsersImplServiceLocator()).getUsersImpl();
      if (usersImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)usersImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)usersImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (usersImpl != null)
      ((javax.xml.rpc.Stub)usersImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public studentInternshipManager.UsersImpl getUsersImpl() {
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl;
  }
  
  public studentInternshipManagerExceptions.Response createTextLog(java.lang.String userID, java.lang.String text, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.createTextLog(userID, text, startTime, endTime);
  }
  
  public studentInternshipManagerExceptions.Response submitTextLog(java.lang.String userID, java.lang.String logID) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.submitTextLog(userID, logID);
  }
  
  public studentInternshipManagerExceptions.Response unlockTextLog(java.lang.String userID, java.lang.String logID) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.unlockTextLog(userID, logID);
  }
  
  public studentInternshipManagerExceptions.Response editInfo(java.lang.String userID, java.lang.String businessMobile, java.lang.String privateMobile, java.lang.String businessMail, java.lang.String privateMail) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.editInfo(userID, businessMobile, privateMobile, businessMail, privateMail);
  }
  
  public studentInternshipManager.LogInformation[] viewStudentLogs(java.lang.String userID) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.viewStudentLogs(userID);
  }
  
  public studentInternshipManagerExceptions.Response disableStudent(java.lang.String userID) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.disableStudent(userID);
  }
  
  public studentInternshipManagerExceptions.Response enableStudent(java.lang.String userID) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.enableStudent(userID);
  }
  
  public studentInternshipManagerExceptions.Response commentStudent(java.lang.String studentID, java.lang.String publicComment, java.lang.String internalComment) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.commentStudent(studentID, publicComment, internalComment);
  }
  
  public studentInternshipManager.UserInformation[] viewAssignedList(java.lang.String userID) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.viewAssignedList(userID);
  }
  
  public studentInternshipManagerExceptions.Response assignUser(java.lang.String mentorID, java.lang.String studentID) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.assignUser(mentorID, studentID);
  }
  
  public java.lang.Object viewPersonalInfo(java.lang.String userID) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.viewPersonalInfo(userID);
  }
  
  public java.lang.Object editTextLog(java.lang.String userID, java.lang.String logID, java.lang.String text) throws java.rmi.RemoteException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.editTextLog(userID, logID, text);
  }
  
  public java.lang.Object createUser(java.lang.String userID, java.lang.String password, java.lang.String name, java.lang.String surname, java.lang.String businessMobile, java.lang.String privateMobile, java.lang.String businessMail, java.lang.String privateMail, java.lang.String role) throws java.rmi.RemoteException, studentInternshipManagerExceptions.InvalidNameException, studentInternshipManagerExceptions.InvalidPhoneNumberException, studentInternshipManagerExceptions.InvalidEmailException{
    if (usersImpl == null)
      _initUsersImplProxy();
    return usersImpl.createUser(userID, password, name, surname, businessMobile, privateMobile, businessMail, privateMail, role);
  }
  
  
}