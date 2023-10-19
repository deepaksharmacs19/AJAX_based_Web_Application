package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
import com.google.gson.*;
import java.util.*;
import java.io.*;

public class ConfirmDeleteDesignation extends HttpServlet
{
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
DesignationDTO designationDTO=designationDAO.getByCode(code);
DesignationBean designationBean=new DesignationBean();
Gson gson=new Gson();

JsonObject jsonObject = new JsonObject();
jsonObject.addProperty("code", designationDTO.getCode());
jsonObject.addProperty("title", designationDTO.getTitle());

response.getWriter().print(jsonObject.toString());
response.getWriter().flush();

}catch(Exception exception){
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