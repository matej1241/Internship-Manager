<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleUsersImplProxyid" scope="session" class="studentInternshipManager.UsersImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleUsersImplProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleUsersImplProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleUsersImplProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        studentInternshipManager.UsersImpl getUsersImpl10mtemp = sampleUsersImplProxyid.getUsersImpl();
if(getUsersImpl10mtemp == null){
%>
<%=getUsersImpl10mtemp %>
<%
}else{
        if(getUsersImpl10mtemp!= null){
        String tempreturnp11 = getUsersImpl10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String userID_1id=  request.getParameter("userID22");
            java.lang.String userID_1idTemp = null;
        if(!userID_1id.equals("")){
         userID_1idTemp  = userID_1id;
        }
        String text_2id=  request.getParameter("text24");
            java.lang.String text_2idTemp = null;
        if(!text_2id.equals("")){
         text_2idTemp  = text_2id;
        }
        String startTime_3id=  request.getParameter("startTime26");
            java.util.Calendar startTime_3idTemp = null;
        if(!startTime_3id.equals("")){
        java.text.DateFormat dateFormatstartTime26 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempstartTime26  = dateFormatstartTime26.parse(startTime_3id);
         startTime_3idTemp = new java.util.GregorianCalendar();
        startTime_3idTemp.setTime(dateTempstartTime26);
        }
        String endTime_4id=  request.getParameter("endTime28");
            java.util.Calendar endTime_4idTemp = null;
        if(!endTime_4id.equals("")){
        java.text.DateFormat dateFormatendTime28 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempendTime28  = dateFormatendTime28.parse(endTime_4id);
         endTime_4idTemp = new java.util.GregorianCalendar();
        endTime_4idTemp.setTime(dateTempendTime28);
        }
        studentInternshipManagerExceptions.Response createTextLog13mtemp = sampleUsersImplProxyid.createTextLog(userID_1idTemp,text_2idTemp,startTime_3idTemp,endTime_4idTemp);
if(createTextLog13mtemp == null){
%>
<%=createTextLog13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">args:</TD>
<TD>
<%
if(createTextLog13mtemp != null){
java.lang.Object[] typeargs16 = createTextLog13mtemp.getArgs();
        String tempargs16 = null;
        if(typeargs16 != null){
        java.util.List listargs16= java.util.Arrays.asList(typeargs16);
        tempargs16 = listargs16.toString();
        }
        %>
        <%=tempargs16%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">message:</TD>
<TD>
<%
if(createTextLog13mtemp != null){
java.lang.String typemessage18 = createTextLog13mtemp.getMessage();
        String tempResultmessage18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemessage18));
        %>
        <%= tempResultmessage18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">code:</TD>
<TD>
<%
if(createTextLog13mtemp != null){
%>
<%=createTextLog13mtemp.getCode()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 30:
        gotMethod = true;
        String userID_5id=  request.getParameter("userID39");
            java.lang.String userID_5idTemp = null;
        if(!userID_5id.equals("")){
         userID_5idTemp  = userID_5id;
        }
        String logID_6id=  request.getParameter("logID41");
            java.lang.String logID_6idTemp = null;
        if(!logID_6id.equals("")){
         logID_6idTemp  = logID_6id;
        }
        studentInternshipManagerExceptions.Response submitTextLog30mtemp = sampleUsersImplProxyid.submitTextLog(userID_5idTemp,logID_6idTemp);
if(submitTextLog30mtemp == null){
%>
<%=submitTextLog30mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">args:</TD>
<TD>
<%
if(submitTextLog30mtemp != null){
java.lang.Object[] typeargs33 = submitTextLog30mtemp.getArgs();
        String tempargs33 = null;
        if(typeargs33 != null){
        java.util.List listargs33= java.util.Arrays.asList(typeargs33);
        tempargs33 = listargs33.toString();
        }
        %>
        <%=tempargs33%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">message:</TD>
<TD>
<%
if(submitTextLog30mtemp != null){
java.lang.String typemessage35 = submitTextLog30mtemp.getMessage();
        String tempResultmessage35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemessage35));
        %>
        <%= tempResultmessage35 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">code:</TD>
<TD>
<%
if(submitTextLog30mtemp != null){
%>
<%=submitTextLog30mtemp.getCode()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 43:
        gotMethod = true;
        String userID_7id=  request.getParameter("userID52");
            java.lang.String userID_7idTemp = null;
        if(!userID_7id.equals("")){
         userID_7idTemp  = userID_7id;
        }
        String logID_8id=  request.getParameter("logID54");
            java.lang.String logID_8idTemp = null;
        if(!logID_8id.equals("")){
         logID_8idTemp  = logID_8id;
        }
        studentInternshipManagerExceptions.Response unlockTextLog43mtemp = sampleUsersImplProxyid.unlockTextLog(userID_7idTemp,logID_8idTemp);
if(unlockTextLog43mtemp == null){
%>
<%=unlockTextLog43mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">args:</TD>
<TD>
<%
if(unlockTextLog43mtemp != null){
java.lang.Object[] typeargs46 = unlockTextLog43mtemp.getArgs();
        String tempargs46 = null;
        if(typeargs46 != null){
        java.util.List listargs46= java.util.Arrays.asList(typeargs46);
        tempargs46 = listargs46.toString();
        }
        %>
        <%=tempargs46%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">message:</TD>
<TD>
<%
if(unlockTextLog43mtemp != null){
java.lang.String typemessage48 = unlockTextLog43mtemp.getMessage();
        String tempResultmessage48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemessage48));
        %>
        <%= tempResultmessage48 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">code:</TD>
<TD>
<%
if(unlockTextLog43mtemp != null){
%>
<%=unlockTextLog43mtemp.getCode()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 56:
        gotMethod = true;
        String userID_9id=  request.getParameter("userID65");
            java.lang.String userID_9idTemp = null;
        if(!userID_9id.equals("")){
         userID_9idTemp  = userID_9id;
        }
        String businessMobile_10id=  request.getParameter("businessMobile67");
            java.lang.String businessMobile_10idTemp = null;
        if(!businessMobile_10id.equals("")){
         businessMobile_10idTemp  = businessMobile_10id;
        }
        String privateMobile_11id=  request.getParameter("privateMobile69");
            java.lang.String privateMobile_11idTemp = null;
        if(!privateMobile_11id.equals("")){
         privateMobile_11idTemp  = privateMobile_11id;
        }
        String businessMail_12id=  request.getParameter("businessMail71");
            java.lang.String businessMail_12idTemp = null;
        if(!businessMail_12id.equals("")){
         businessMail_12idTemp  = businessMail_12id;
        }
        String privateMail_13id=  request.getParameter("privateMail73");
            java.lang.String privateMail_13idTemp = null;
        if(!privateMail_13id.equals("")){
         privateMail_13idTemp  = privateMail_13id;
        }
        studentInternshipManagerExceptions.Response editInfo56mtemp = sampleUsersImplProxyid.editInfo(userID_9idTemp,businessMobile_10idTemp,privateMobile_11idTemp,businessMail_12idTemp,privateMail_13idTemp);
if(editInfo56mtemp == null){
%>
<%=editInfo56mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">args:</TD>
<TD>
<%
if(editInfo56mtemp != null){
java.lang.Object[] typeargs59 = editInfo56mtemp.getArgs();
        String tempargs59 = null;
        if(typeargs59 != null){
        java.util.List listargs59= java.util.Arrays.asList(typeargs59);
        tempargs59 = listargs59.toString();
        }
        %>
        <%=tempargs59%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">message:</TD>
<TD>
<%
if(editInfo56mtemp != null){
java.lang.String typemessage61 = editInfo56mtemp.getMessage();
        String tempResultmessage61 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemessage61));
        %>
        <%= tempResultmessage61 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">code:</TD>
<TD>
<%
if(editInfo56mtemp != null){
%>
<%=editInfo56mtemp.getCode()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 75:
        gotMethod = true;
        String userID_14id=  request.getParameter("userID78");
            java.lang.String userID_14idTemp = null;
        if(!userID_14id.equals("")){
         userID_14idTemp  = userID_14id;
        }
        studentInternshipManager.LogInformation[] viewStudentLogs75mtemp = sampleUsersImplProxyid.viewStudentLogs(userID_14idTemp);
if(viewStudentLogs75mtemp == null){
%>
<%=viewStudentLogs75mtemp %>
<%
}else{
        String tempreturnp76 = null;
        if(viewStudentLogs75mtemp != null){
        java.util.List listreturnp76= java.util.Arrays.asList(viewStudentLogs75mtemp);
        tempreturnp76 = listreturnp76.toString();
        }
        %>
        <%=tempreturnp76%>
        <%
}
break;
case 80:
        gotMethod = true;
        String userID_15id=  request.getParameter("userID89");
            java.lang.String userID_15idTemp = null;
        if(!userID_15id.equals("")){
         userID_15idTemp  = userID_15id;
        }
        studentInternshipManagerExceptions.Response disableStudent80mtemp = sampleUsersImplProxyid.disableStudent(userID_15idTemp);
if(disableStudent80mtemp == null){
%>
<%=disableStudent80mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">args:</TD>
<TD>
<%
if(disableStudent80mtemp != null){
java.lang.Object[] typeargs83 = disableStudent80mtemp.getArgs();
        String tempargs83 = null;
        if(typeargs83 != null){
        java.util.List listargs83= java.util.Arrays.asList(typeargs83);
        tempargs83 = listargs83.toString();
        }
        %>
        <%=tempargs83%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">message:</TD>
<TD>
<%
if(disableStudent80mtemp != null){
java.lang.String typemessage85 = disableStudent80mtemp.getMessage();
        String tempResultmessage85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemessage85));
        %>
        <%= tempResultmessage85 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">code:</TD>
<TD>
<%
if(disableStudent80mtemp != null){
%>
<%=disableStudent80mtemp.getCode()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 91:
        gotMethod = true;
        String userID_16id=  request.getParameter("userID100");
            java.lang.String userID_16idTemp = null;
        if(!userID_16id.equals("")){
         userID_16idTemp  = userID_16id;
        }
        studentInternshipManagerExceptions.Response enableStudent91mtemp = sampleUsersImplProxyid.enableStudent(userID_16idTemp);
if(enableStudent91mtemp == null){
%>
<%=enableStudent91mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">args:</TD>
<TD>
<%
if(enableStudent91mtemp != null){
java.lang.Object[] typeargs94 = enableStudent91mtemp.getArgs();
        String tempargs94 = null;
        if(typeargs94 != null){
        java.util.List listargs94= java.util.Arrays.asList(typeargs94);
        tempargs94 = listargs94.toString();
        }
        %>
        <%=tempargs94%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">message:</TD>
<TD>
<%
if(enableStudent91mtemp != null){
java.lang.String typemessage96 = enableStudent91mtemp.getMessage();
        String tempResultmessage96 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemessage96));
        %>
        <%= tempResultmessage96 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">code:</TD>
<TD>
<%
if(enableStudent91mtemp != null){
%>
<%=enableStudent91mtemp.getCode()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 102:
        gotMethod = true;
        String studentID_17id=  request.getParameter("studentID111");
            java.lang.String studentID_17idTemp = null;
        if(!studentID_17id.equals("")){
         studentID_17idTemp  = studentID_17id;
        }
        String publicComment_18id=  request.getParameter("publicComment113");
            java.lang.String publicComment_18idTemp = null;
        if(!publicComment_18id.equals("")){
         publicComment_18idTemp  = publicComment_18id;
        }
        String internalComment_19id=  request.getParameter("internalComment115");
            java.lang.String internalComment_19idTemp = null;
        if(!internalComment_19id.equals("")){
         internalComment_19idTemp  = internalComment_19id;
        }
        studentInternshipManagerExceptions.Response commentStudent102mtemp = sampleUsersImplProxyid.commentStudent(studentID_17idTemp,publicComment_18idTemp,internalComment_19idTemp);
if(commentStudent102mtemp == null){
%>
<%=commentStudent102mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">args:</TD>
<TD>
<%
if(commentStudent102mtemp != null){
java.lang.Object[] typeargs105 = commentStudent102mtemp.getArgs();
        String tempargs105 = null;
        if(typeargs105 != null){
        java.util.List listargs105= java.util.Arrays.asList(typeargs105);
        tempargs105 = listargs105.toString();
        }
        %>
        <%=tempargs105%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">message:</TD>
<TD>
<%
if(commentStudent102mtemp != null){
java.lang.String typemessage107 = commentStudent102mtemp.getMessage();
        String tempResultmessage107 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemessage107));
        %>
        <%= tempResultmessage107 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">code:</TD>
<TD>
<%
if(commentStudent102mtemp != null){
%>
<%=commentStudent102mtemp.getCode()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 117:
        gotMethod = true;
        String userID_20id=  request.getParameter("userID120");
            java.lang.String userID_20idTemp = null;
        if(!userID_20id.equals("")){
         userID_20idTemp  = userID_20id;
        }
        studentInternshipManager.UserInformation[] viewAssignedList117mtemp = sampleUsersImplProxyid.viewAssignedList(userID_20idTemp);
if(viewAssignedList117mtemp == null){
%>
<%=viewAssignedList117mtemp %>
<%
}else{
        String tempreturnp118 = null;
        if(viewAssignedList117mtemp != null){
        java.util.List listreturnp118= java.util.Arrays.asList(viewAssignedList117mtemp);
        tempreturnp118 = listreturnp118.toString();
        }
        %>
        <%=tempreturnp118%>
        <%
}
break;
case 122:
        gotMethod = true;
        String mentorID_21id=  request.getParameter("mentorID131");
            java.lang.String mentorID_21idTemp = null;
        if(!mentorID_21id.equals("")){
         mentorID_21idTemp  = mentorID_21id;
        }
        String studentID_22id=  request.getParameter("studentID133");
            java.lang.String studentID_22idTemp = null;
        if(!studentID_22id.equals("")){
         studentID_22idTemp  = studentID_22id;
        }
        studentInternshipManagerExceptions.Response assignUser122mtemp = sampleUsersImplProxyid.assignUser(mentorID_21idTemp,studentID_22idTemp);
if(assignUser122mtemp == null){
%>
<%=assignUser122mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">args:</TD>
<TD>
<%
if(assignUser122mtemp != null){
java.lang.Object[] typeargs125 = assignUser122mtemp.getArgs();
        String tempargs125 = null;
        if(typeargs125 != null){
        java.util.List listargs125= java.util.Arrays.asList(typeargs125);
        tempargs125 = listargs125.toString();
        }
        %>
        <%=tempargs125%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">message:</TD>
<TD>
<%
if(assignUser122mtemp != null){
java.lang.String typemessage127 = assignUser122mtemp.getMessage();
        String tempResultmessage127 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemessage127));
        %>
        <%= tempResultmessage127 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">code:</TD>
<TD>
<%
if(assignUser122mtemp != null){
%>
<%=assignUser122mtemp.getCode()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 135:
        gotMethod = true;
        String userID_23id=  request.getParameter("userID138");
            java.lang.String userID_23idTemp = null;
        if(!userID_23id.equals("")){
         userID_23idTemp  = userID_23id;
        }
        java.lang.Object viewPersonalInfo135mtemp = sampleUsersImplProxyid.viewPersonalInfo(userID_23idTemp);
if(viewPersonalInfo135mtemp == null){
%>
<%=viewPersonalInfo135mtemp %>
<%
}else{
        String tempResultreturnp136 = org.eclipse.jst.ws.util.JspUtils.markup(viewPersonalInfo135mtemp.toString());
        %>
        <%= tempResultreturnp136 %>
        <%
}
break;
case 140:
        gotMethod = true;
        String userID_24id=  request.getParameter("userID143");
            java.lang.String userID_24idTemp = null;
        if(!userID_24id.equals("")){
         userID_24idTemp  = userID_24id;
        }
        String logID_25id=  request.getParameter("logID145");
            java.lang.String logID_25idTemp = null;
        if(!logID_25id.equals("")){
         logID_25idTemp  = logID_25id;
        }
        String text_26id=  request.getParameter("text147");
            java.lang.String text_26idTemp = null;
        if(!text_26id.equals("")){
         text_26idTemp  = text_26id;
        }
        java.lang.Object editTextLog140mtemp = sampleUsersImplProxyid.editTextLog(userID_24idTemp,logID_25idTemp,text_26idTemp);
if(editTextLog140mtemp == null){
%>
<%=editTextLog140mtemp %>
<%
}else{
        String tempResultreturnp141 = org.eclipse.jst.ws.util.JspUtils.markup(editTextLog140mtemp.toString());
        %>
        <%= tempResultreturnp141 %>
        <%
}
break;
case 149:
        gotMethod = true;
        String userID_27id=  request.getParameter("userID152");
            java.lang.String userID_27idTemp = null;
        if(!userID_27id.equals("")){
         userID_27idTemp  = userID_27id;
        }
        String password_28id=  request.getParameter("password154");
            java.lang.String password_28idTemp = null;
        if(!password_28id.equals("")){
         password_28idTemp  = password_28id;
        }
        String name_29id=  request.getParameter("name156");
            java.lang.String name_29idTemp = null;
        if(!name_29id.equals("")){
         name_29idTemp  = name_29id;
        }
        String surname_30id=  request.getParameter("surname158");
            java.lang.String surname_30idTemp = null;
        if(!surname_30id.equals("")){
         surname_30idTemp  = surname_30id;
        }
        String businessMobile_31id=  request.getParameter("businessMobile160");
            java.lang.String businessMobile_31idTemp = null;
        if(!businessMobile_31id.equals("")){
         businessMobile_31idTemp  = businessMobile_31id;
        }
        String privateMobile_32id=  request.getParameter("privateMobile162");
            java.lang.String privateMobile_32idTemp = null;
        if(!privateMobile_32id.equals("")){
         privateMobile_32idTemp  = privateMobile_32id;
        }
        String businessMail_33id=  request.getParameter("businessMail164");
            java.lang.String businessMail_33idTemp = null;
        if(!businessMail_33id.equals("")){
         businessMail_33idTemp  = businessMail_33id;
        }
        String privateMail_34id=  request.getParameter("privateMail166");
            java.lang.String privateMail_34idTemp = null;
        if(!privateMail_34id.equals("")){
         privateMail_34idTemp  = privateMail_34id;
        }
        String role_35id=  request.getParameter("role168");
            java.lang.String role_35idTemp = null;
        if(!role_35id.equals("")){
         role_35idTemp  = role_35id;
        }
        java.lang.Object createUser149mtemp = sampleUsersImplProxyid.createUser(userID_27idTemp,password_28idTemp,name_29idTemp,surname_30idTemp,businessMobile_31idTemp,privateMobile_32idTemp,businessMail_33idTemp,privateMail_34idTemp,role_35idTemp);
if(createUser149mtemp == null){
%>
<%=createUser149mtemp %>
<%
}else{
        String tempResultreturnp150 = org.eclipse.jst.ws.util.JspUtils.markup(createUser149mtemp.toString());
        %>
        <%= tempResultreturnp150 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>