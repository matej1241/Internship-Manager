package studentInternshipManager;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import studentInternshipManagerExceptions.InvalidEmailException;
import studentInternshipManagerExceptions.InvalidNameException;
import studentInternshipManagerExceptions.InvalidPhoneNumberException;



public class DatabaseCommunication extends MyConstants{
  
  public String dbURL = "jdbc:sqlite:C:/Users/Matej/workspace/SIM_WebP/db/Users.db"; 
  public String dbClass = "org.sqlite.JDBC";
  public String username = ""; 
  public String password = "";
  
  Connection conn = null;
  PreparedStatement stmt = null;
  ResultSet rs = null;
    
  Connection openConnection(){
	  try{
		  Class.forName(dbClass);
          Connection conn = DriverManager.getConnection(dbURL, username, password);
          conn.createStatement().execute("PRAGMA foreign_keys = ON");
          return conn;
	  }
	  catch (ClassNotFoundException e){
		  e.printStackTrace();;
	  }
	  catch (SQLException e){
		  e.printStackTrace();;
	  }
	  return conn;
  }

 
  public void submitTextLog (String userID, String logID)
  	{
	  
	  try{
	      conn = openConnection();
	      stmt = conn.prepareStatement("UPDATE Log SET log_status=" + LOG_STATUS_LOCKED + " WHERE log_id=? AND Owner = ?");
	      stmt.setString(1, logID);
	      stmt.setString(2, userID);
	      stmt.execute();
	  }
	  catch (SQLException e){
          e.printStackTrace();
      }
	  finally{
		  if (conn != null){
			  try{
				  conn.close();
			  }
			  catch (SQLException e){
				  e.printStackTrace();
			  }
		  }
	  }
  	}

  
  public void unlockTextLog (String userID, String logID)
	{
	  
	  try{
	      conn = openConnection();
	      stmt = conn.prepareStatement("UPDATE Log SET log_status=" + LOG_STATUS_UNLOCKED + " WHERE log_id=? AND Owner = ?");
	      stmt.setString(1, logID);
	      stmt.setString(2, userID);
	      stmt.execute();
	  }
	  catch (SQLException e){
        e.printStackTrace();
    }
	  finally{
		  if (conn != null){
			  try{
				  conn.close();
			  }
			  catch (SQLException e){
				  e.printStackTrace();
			  }
		  }
	  }
	} 
  

  public void createTextLog (String userID, String text, Date startTime, Date endTime){
	  
    String[] args = {userID, text, startTime.toString(), endTime.toString()};
    
    try
      {
        conn = openConnection();
        stmt = conn.prepareStatement("INSERT INTO Log (Owner, text, start_time, end_time, log_status)"
            + "VALUES (?, ?, ?, ?, 1)");
        for(int i = 0; i < args.length; i++)
          {
            stmt.setString((i+1), args[i]);
          }
        stmt.execute();
      }
    
	  catch (SQLException e){
		  e.printStackTrace();
	  }
	  finally{
		  if (conn != null){
			  try{
				  conn.close();
			  }
			  catch (SQLException e){
				  e.printStackTrace();
			  }
		  }
	  }
  }


  public UserInformation createUser (String userID, String password, String name, String surname, 
                                     String businessMobile, String privateMobile,
                                     String businessMail, String privateMail,  String role)
                                     throws InvalidNameException, InvalidEmailException, InvalidPhoneNumberException, SQLException 
  	{
	  UserInformation userInfo = new UserInformation();
	  String[] args = {userID, password, name, surname, businessMobile, privateMobile, businessMail, privateMail, role};
		  
	  try{
		  conn = openConnection();
      stmt = conn.prepareStatement("INSERT INTO User VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

      for(int i = 0; i < args.length; i++)
        {
          stmt.setString((i+1), args[i]);
        }
       
      stmt.execute();
		  
		  userInfo.userID = userID;
		  userInfo.name = name;
		  userInfo.surname = surname;
		  userInfo.password = password;
		  userInfo.businessMail = businessMail;
		  userInfo.privateMail = privateMail;
		  userInfo.businessMobile = businessMobile;
		  userInfo.privateMobile = privateMobile;
		  userInfo.role = role;
		  return userInfo;
	  }

	  finally{
		  if(conn != null){
			  try{
				  conn.close();
			  }
			  catch (SQLException e){
				  e.printStackTrace();
			  }
		  }
	  }

  }
  
 
  public void assignUser(String mentorID, String studentID){
	  
	  try{
	    conn = openConnection();
      stmt = conn.prepareStatement("INSERT INTO Assign (mentor_id, student_id) "
                                        + "VALUES (?, ?)");
      stmt.setString(1, mentorID);
      stmt.setString(2, studentID);
      stmt.execute();
	  }
	  catch (SQLException e){
		  e.printStackTrace();
	  }
	  finally{
			if(conn != null){
				try{
					conn.close();
				}
				catch (SQLException e){
					e.printStackTrace();
				}
			}
	  }
  }  
  

  public UserInformation[] viewStudentAssignedList( String userID){
	  
	  Collection<UserInformation> assignedList = new ArrayList<UserInformation>();
	  
	  try{
			  stmt = conn.prepareStatement("SELECT User.name, User.surname, User.b_mobile, User.p_mobile, User.b_email, User.p_email\n"
											+"FROM User\n"
											+"INNER JOIN Assign\n"
											+"ON Assign.mentor_id=User.user_id WHERE Assign.student_id=?");
			  stmt.setString(1, userID);
			  rs = stmt.executeQuery();
			  			  
			  while (rs.next())
			  {
				  UserInformation info = new UserInformation();
				  info.setName(rs.getString("name"));
				  info.setSurname(rs.getString("surname"));
				  info.setBusinessMobile(rs.getString("b_mobile"));
				  info.setPrivateMobile(rs.getString("p_mobile"));
				  info.setBusinessMail(rs.getString("b_email"));
				  info.setPrivateMail(rs.getString("p_email"));
				  assignedList.add(info);
			  }
		  
		  }
	  
	  catch (SQLException e)
	  {
		  e.printStackTrace();
	  }
	  finally
	  {
		  if (conn != null){
			    try{
				  conn.close();
			  }
			  catch(SQLException e){
				  e.printStackTrace();
			  }
		  }
}

	  return assignedList.toArray(new UserInformation[0]);
 }

  
  public UserInformation[] viewMentorAssignedList( String userID){
    
    Collection<UserInformation> assignedList = new ArrayList<UserInformation>();
    
    try{
          stmt = conn.prepareStatement("SELECT User.name, User.surname\n"
                                      +"FROM User\n"
                                      +"INNER JOIN Assign\n"
                                      +"ON Assign.student_id=User.user_id WHERE Assign.mentor_id=?");
        stmt.setString(1, userID);
        rs = stmt.executeQuery();
                
        while (rs.next())
        {
          UserInformation info = new UserInformation();
          info.setName(rs.getString("name"));
          info.setSurname(rs.getString("surname"));
          info.setBusinessMobile(rs.getString("b_mobile"));
          info.setPrivateMobile(rs.getString("p_mobile"));
          info.setBusinessMail(rs.getString("b_email"));
          info.setPrivateMail(rs.getString("p_email"));
          assignedList.add(info);
        }
      
      }
    
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (conn != null){
          try{
          conn.close();
        }
        catch(SQLException e){
          e.printStackTrace();
        }
      }
}

    return assignedList.toArray(new UserInformation[0]);
 } 
  
  
  public void editInfo( String userID, String businessMobile, String privateMobile,
		                    String businessMail, String privateMail){
	  
	  List<String> params = new ArrayList<String>();
	  List<String> cols = new ArrayList<String>();
	  
	  String query = "UPDATE User SET ";
	  
	  if(businessMobile != null){
		  params.add(businessMobile);
		  cols.add("b_mobile=?");
	  }
	  if(privateMobile != null){
		  params.add(privateMobile);
		  cols.add("p_mobile=?");
	  }
	  if(businessMail != null){
		  params.add(businessMail);
		  cols.add("b_email=?");
	  }
	  if(privateMail != null){
		  params.add(privateMail);
		  cols.add("p_email=?");
	  }
	  if(userID != null){
		  params.add(userID);
	  }
	  String pms = String.join(", ", cols);
	  query += pms;
	  query += " WHERE user_id=?";
	  query.toString();
	  
	  try{
		  conn = openConnection();
		  stmt = conn.prepareStatement(query);
		  
		  for(int i=0; i < params.size(); i++){
			  stmt.setString(i+1, params.get(i).toString());
		  }
		  stmt.execute();
	  }
	  catch(SQLException e){
		  e.printStackTrace();
	  }
	  finally{
		  if(conn != null){
			  try{
				  conn.close();
			  }
			  catch(SQLException e){
				  e.printStackTrace();
			  }
		  }
	  } 
  }
  
  
  public LogInformation[] viewStudentLogs( String userID){
	  
	  Collection<LogInformation> studentLogsResponse = new ArrayList<LogInformation>();
	  
	  try{
		  conn = openConnection();
		  stmt = conn.prepareStatement("SELECT log_id, text, start_time, end_time, Date, log_status FROM Log WHERE Owner=?");
		  stmt.setString(1, userID);
		  rs = stmt.executeQuery();
		  
		  while (rs.next()){
			  LogInformation log = new LogInformation();
			  log.setLogID(rs.getString("log_id"));
			  log.setText(rs.getString("text"));
			  log.setStartTime(rs.getString("start_time"));
			  log.setEndTime(rs.getString("end_time"));
			  log.setDate(rs.getString("Date"));
			  log.setLogStatus(rs.getString("log_status"));
			  studentLogsResponse.add(log);
		  }
	  }
	  catch (SQLException e){
		  e.printStackTrace();
	  }
	  finally {
		  if (conn != null){
			  try {
				  conn.close();
			  }
			  catch (SQLException e){
				  e.printStackTrace();
			  }
		  }
	  }
	  return studentLogsResponse.toArray(new LogInformation[0]);
  }  


  public void disableStudent(String userID){
	  
	  try{
		  conn = openConnection();
          stmt = conn.prepareStatement("UPDATE User_student_ext SET student_status='" +STUDENT_STATUS_DISABLED+ "' WHERE student_id=?");
          stmt.setString(1, userID);
          stmt.execute();
	  }
	  catch (SQLException e){
          e.printStackTrace();
      }
	  finally{
		  if (conn != null){
			  try{
				  conn.close();
			  }
			  catch (SQLException e){
				  e.printStackTrace();
			  }
		  }
	  }
  }
  
  
  public int getUserRole(String userID)
  {
    int userRole = 3;
    try
      {
        conn = openConnection();
        stmt = conn.prepareStatement("SELECT role FROM User WHERE user_id=?");
        stmt.setString(1, userID);
        rs = stmt.executeQuery();
          while (rs.next()) 
            {
              userRole = rs.getInt("role");
            }
      }
    
    catch (SQLException e) 
      {
        e.printStackTrace();
      }
    
    finally 
    {
      if (conn != null) 
        {
          try 
            {
              conn.close();
            } 
          catch (SQLException e) 
            {
              e.printStackTrace();
            }
        }

    }
    return userRole;
  } 



  public int getStudentStatus(String userID)
  {
	int studentStatus = 3;
	try
		{
			conn = openConnection();
			stmt = conn.prepareStatement("SELECT student_status FROM User_student_ext WHERE student_id=?");
			stmt.setString(1, userID);
			rs = stmt.executeQuery();
			
			while (rs.next()) 
            {
              studentStatus = rs.getInt("student_status");
            }
		}
	
	catch (SQLException e) 
    	{
			e.printStackTrace();
    	}
  
	finally 
		{
		if (conn != null) 
			{
				try 
					{
						conn.close();
					} 
				catch (SQLException e) 
					{
						e.printStackTrace();
					}
			}
		}
	
	return studentStatus;
  }
  
  
  public void enableStudent(String userID)
  {
	  try
	  	{
		  conn = openConnection();
		  stmt = conn.prepareStatement("UPDATE User_student_ext SET student_status='" +STUDENT_STATUS_ACTIVE+ "' WHERE student_id=?");
		  stmt.setString(1, userID);
          stmt.execute();
	  	}
	  
	  catch (SQLException e) 
  		{
		  e.printStackTrace();
  		}

	  finally 
		{
		if (conn != null) 
			{
				try 
					{
						conn.close();
					} 
				catch (SQLException e) 
					{
						e.printStackTrace();
					}
			}
		}
  }
  
  public void commentStudent(String studentID, String publicComment, String internalComment)
  {
	  if(publicComment == null)
		  publicComment = "";

	  if(internalComment == null)
		  internalComment = "";
	  
	  try
	  	{
		  conn = openConnection();
		  stmt = conn.prepareStatement("UPDATE User_student_ext SET public_comment = ?, internal_comment = ? WHERE student_id = ?");
		  stmt.setString(1, publicComment);
		  stmt.setString(2, internalComment);
		  stmt.setString(3, studentID);
		  stmt.execute();
	  	}
	  
	  catch (SQLException e) 
		{
		  e.printStackTrace();
		}

	  finally 
		{
		if (conn != null) 
			{
				try 
					{
						conn.close();
					} 
				catch (SQLException e) 
					{
						e.printStackTrace();
					}
			}
		}
  }
  
  public UserInformation viewPersonalInfo(String userID)
  	{
	  UserInformation personalInfo = new UserInformation();
	  try
	  {
		  conn = openConnection();
		  stmt = conn.prepareStatement("SELECT name, surname, b_mobile, p_mobile, b_email, p_email, role FROM User WHERE user_id=?");
		  stmt.setString(1, userID);
		  rs = stmt.executeQuery();
		  
		  while (rs.next()){
			  personalInfo.setName(rs.getString("name"));
			  personalInfo.setSurname(rs.getString("surname"));
			  personalInfo.setBusinessMobile(rs.getString("b_mobile"));
			  personalInfo.setPrivateMobile(rs.getString("p_mobile"));
			  personalInfo.setBusinessMail(rs.getString("b_email"));
			  personalInfo.setPrivateMail(rs.getString("p_email"));
			  personalInfo.setRole(rs.getString("role"));
		  }
	  }
	  
	  catch (SQLException e) 
		{
		  e.printStackTrace();
		}

	  finally 
		{
		if (conn != null) 
			{
				try 
					{
						conn.close();
					} 
				catch (SQLException e) 
					{
						e.printStackTrace();
					}
			}
		}
	  
	  return personalInfo;
  	}
  
  public int getLogStatus(String logID)
  {
	  int logStatus = 3;
	  try
	  {
		  conn = openConnection();
		  stmt = conn.prepareStatement("SELECT log_status FROM Log WHERE log_id = ?");
		  stmt.setString(1, logID);
		  rs = stmt.executeQuery();	  
		  
		  while (rs.next())
		  	{
			  logStatus = rs.getInt("log_status");
		  	}
	  }
	  
	  catch (SQLException e) 
		{
		  e.printStackTrace();
		}

	  finally 
		{
		if (conn != null) 
			{
				try 
					{
						conn.close();
					} 
				catch (SQLException e) 
					{
						e.printStackTrace();
					}
			}
		}
	  
	  return logStatus;
  }
  
  public void editTextLog(String logID, String text)
  {
	  try
	  {
		  conn = openConnection();
		  stmt = conn.prepareStatement("UPDATE Log SET text = ? WHERE log_id = ? ");
		  stmt.setString(1, text);
		  stmt.setString(2,  logID);
		  stmt.execute();
	  }
	  
	  catch (SQLException e) 
		{
		  e.printStackTrace();
		}

	  finally 
		{
		if (conn != null) 
			{
				try 
					{
						conn.close();
					} 
				catch (SQLException e) 
					{
						e.printStackTrace();
					}
			}
		}
  }
  	
}


