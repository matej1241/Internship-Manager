/**
 * SIMImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package studentInternshipManager;

public interface SIMImpl extends java.rmi.Remote {
    public studentInternshipManagerExceptions.Response createTextLog(java.lang.String userID, java.lang.String text, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException;
    public studentInternshipManagerExceptions.Response submitTextLog(java.lang.String userID, java.lang.String logID) throws java.rmi.RemoteException;
    public studentInternshipManagerExceptions.Response unlockTextLog(java.lang.String userID, java.lang.String logID) throws java.rmi.RemoteException;
    public studentInternshipManagerExceptions.Response editInfo(java.lang.String userID, java.lang.String businessMobile, java.lang.String privateMobile, java.lang.String businessMail, java.lang.String privateMail) throws java.rmi.RemoteException;
    public studentInternshipManager.LogInformation[] viewStudentLogs(java.lang.String userID) throws java.rmi.RemoteException;
    public studentInternshipManagerExceptions.Response disableStudent(java.lang.String userID) throws java.rmi.RemoteException;
    public studentInternshipManagerExceptions.Response enableStudent(java.lang.String userID) throws java.rmi.RemoteException;
    public studentInternshipManagerExceptions.Response commentStudent(java.lang.String studentID, java.lang.String publicComment, java.lang.String internalComment) throws java.rmi.RemoteException;
    public studentInternshipManager.UserInformation[] viewAssignedList(java.lang.String userID) throws java.rmi.RemoteException;
    public studentInternshipManagerExceptions.Response assignUser(java.lang.String mentorID, java.lang.String studentID) throws java.rmi.RemoteException;
    public java.lang.Object viewPersonalInfo(java.lang.String userID) throws java.rmi.RemoteException;
    public java.lang.Object editTextLog(java.lang.String userID, java.lang.String logID, java.lang.String text) throws java.rmi.RemoteException;
    public java.lang.Object createUser(java.lang.String userID, java.lang.String password, java.lang.String name, java.lang.String surname, java.lang.String businessMobile, java.lang.String privateMobile, java.lang.String businessMail, java.lang.String privateMail, java.lang.String role) throws java.rmi.RemoteException, studentInternshipManagerExceptions.InvalidNameException, studentInternshipManagerExceptions.InvalidPhoneNumberException, studentInternshipManagerExceptions.InvalidEmailException;
}
