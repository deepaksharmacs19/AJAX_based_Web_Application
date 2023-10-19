package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
import com.google.gson.*;

public class EditDesignation extends HttpServlet
{


public void doPost(HttpServletRequest request, HttpServletResponse response)
{
int code=Integer.parseInt(request.getParameter("code"));

try{
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designationDTO;
designationDTO=designationDAO.getByCode(code);
Gson gson=new Gson();
String jsonString=gson.toJson(designationDTO);
response.getWriter().print(jsonString);
response.getWriter().flush();

}catch(Exception exception)
{
try{
response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
response.setContentType("text/plain");
response.getWriter().print(exception.getMessage());
}catch(Exception except)
{

}

}
}
}