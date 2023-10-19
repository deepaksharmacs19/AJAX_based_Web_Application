package com.thinking.machines.hr.servlets;
import javax.servlet.http.*;
import javax.servlet.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import com.google.gson.*;
import java.io.*;
import java.util.*;

public class UpdateDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
{




DesignationDTO designationDTO=new DesignationDTO();
//designationDTO.setCode(designationBean.getCode());
//designationDTO.setTitle(designationBean.getTitle());


DesignationDAO designationDAO=new DesignationDAO();

int code=Integer.parseInt(request.getParameter("code"));
String title=request.getParameter("title");
designationDTO.setCode(code);
designationDTO.setTitle(title);

try{
designationDAO.update(designationDTO);

Message message=new Message();
message.setHeading("Designation (Edit Module)");
message.setMessage("Designation updated");
message.setGenerateButtons(true);
message.setGenerateTwoButtons(false);
message.setButtonOneText("ok");
message.setButtonOneAction("Designations.jsp");

Gson gson=new Gson();
String jsonString=gson.toJson(message);
response.setContentType("application/json");
response.getWriter().print(jsonString);
response.getWriter().flush();
}
catch(Exception exception)
{
// if it comes here then there could be some problem and we have to send the errorbean as well as designationBean and if we are not sending designation bean from here then DesignationEditForm will not be having any code to use for hidden form field and hence it will give error.

try{
response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
response.setContentType("text/plain");
response.getWriter().print(exception.getMessage());
}
catch(Exception except)
{

}

}// catch ends here

}// function ends here
}