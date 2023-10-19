package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.*;
import java.io.*;

public class AddDesignation extends HttpServlet
{

public void doPost(HttpServletRequest request, HttpServletResponse response)
{
PrintWriter pw;
try{
String title=request.getParameter("title");
DesignationDTO designationDTO=new DesignationDTO();
designationDTO.setTitle(title);
DesignationDAO designationDAO=new DesignationDAO();

try{
designationDAO.add(designationDTO);

Message message;
message=new Message();

message.setHeading("Designation (Add Module)");
message.setMessage("Designation added, add more ?");
message.setGenerateButtons(true);
message.setGenerateTwoButtons(true);
message.setButtonOneText("Yes");
message.setButtonOneAction("DesignationAddForm.jsp");
message.setButtonTwoText("No");
message.setButtonTwoAction("Designations.jsp");

Gson gson=new Gson();
String jsonString=gson.toJson(message,Message.class);
response.setContentType("application/json");

System.out.println(jsonString);

pw=response.getWriter();

pw.print(jsonString);
pw.flush();
}
catch(DAOException daoException)
{
response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
response.setContentType("text/plain");
response.getWriter().print(daoException.getMessage());
}

}catch(Exception e)
{
response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
response.setContentType("text/plain");
try{
response.getWriter().print(e.getMessage());
}catch(Exception except)
{

}

}
}

}