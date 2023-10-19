package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.hr.dl.*;
import com.google.gson.*;

public class Login extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response){

}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{

String username=(String)request.getParameter("username");
String password=(String)request.getParameter("password");
System.out.println(username+" "+password);
if(username==null)
{
try{
 response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType("text/plain");
        response.getWriter().print("username required");
}catch(Exception e)
{

}
}


AdministratorDAO adminDAO=new AdministratorDAO();

try{
response.setContentType("application/json");
PrintWriter pw=response.getWriter();

System.out.println("came upto getByUsername");
adminDAO.getByUsername(username);
AdministratorDTO adminDTO=new AdministratorDTO();
adminDTO.setUsername(username);
adminDTO.setPassword(password);

Gson gson=new Gson();
String jsonString=gson.toJson(adminDTO);
System.out.println(jsonString);

pw.print(jsonString);
}catch(Exception exception)
{
try{
System.out.println("Exception raised");
 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("text/plain");
        response.getWriter().print("Invalid username / password");
}catch(Exception e)
{
System.out.println("Last Exception raised"+e);

}

}

}
}