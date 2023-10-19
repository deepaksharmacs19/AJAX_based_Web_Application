package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
import com.google.gson.*;
import java.util.*;
import java.io.*;


public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
{
try{
request.getRequestDispatcher("/LoginForm.jsp").forward(request,response);
}catch(Exception exception)
{
System.out.println(exception);
}
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
{
try{

response.setContentType("application/json");
PrintWriter pw=response.getWriter();

BufferedReader br=request.getReader();
String d;
StringBuffer b=new StringBuffer();

while(true)
{
d=br.readLine();
if(d==null) break;
b.append(d);
}

System.out.println(b);
int code=Integer.parseInt(b.toString().split("=")[1]);

DesignationDAO designationDAO=new DesignationDAO();
designationDAO.deleteByCode(code);

Message message=new Message();
message.setHeading("Designation (Delete Module)");
message.setMessage("Designation deleted");
message.setGenerateButtons(true);
message.setGenerateTwoButtons(false);
message.setButtonOneText("ok");
message.setButtonOneAction("Designations.jsp");

Gson gson=new Gson();
String jsonString=gson.toJson(message);
pw.print(jsonString);
pw.flush();
}
catch(Exception exception)
{
System.out.println(exception);	
try{

response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
response.setContentType("text/plain");
try{
response.getWriter().print(exception.getMessage());
}catch(Exception except)
{

}

}
catch(Exception except)
{

}

}

}
}