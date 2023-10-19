package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import com.google.gson.*;

public class Designations extends HttpServlet
{

public void doPost(HttpServletRequest request, HttpServletResponse response)
{
String str="";
try{

try{
List<DesignationDTO> designations=new DesignationDAO().getAll();
response.setContentType("application/json");
PrintWriter pw=response.getWriter();
int i=0;

Gson gson=new Gson();
String jsonString=gson.toJson(designations);

pw.println(jsonString);
pw.flush();
}
catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/DesignationAddForm.jsp");
requestDispatcher.forward(request,response);
}

}catch(Exception e)
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
System.out.println(e);
try{
requestDispatcher.forward(request,response);
}catch(Exception exception)
{

}

}
}

}