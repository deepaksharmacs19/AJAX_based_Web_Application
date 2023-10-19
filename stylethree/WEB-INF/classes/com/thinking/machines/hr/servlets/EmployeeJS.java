package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.bl.*;
import com.thinking.machines.hr.beans.*; 
import javax.servlet.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;

public class EmployeeJS extends HttpServlet
{

public void doGet(HttpServletRequest request, HttpServletResponse response)
{
doPost(request,response);
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
{
File file;
RandomAccessFile randomAccessFile;

try{
ServletContext servletContext=getServletContext();

file=new File(servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Employees.js");

randomAccessFile=new RandomAccessFile(file,"rw");

PrintWriter pw=response.getWriter();
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
pw.println(randomAccessFile.readLine());
}

EmployeeBL bl=new EmployeeBL();
List<EmployeeBean> employees=bl.getAll();
pw.println("var employee;");
int i=0;
for(EmployeeBean bean:employees)
{
pw.println("employee=new Employee()");
pw.println("employee.employeeId=\""+bean.getEmployeeId()+"\";");
pw.println("employee.name=\""+bean.getName()+"\"");
pw.println("employee.designationCode="+bean.getDesignationCode()+";");
pw.println("employee.designation=\""+bean.getDesignation()+"\";");
pw.println("employee.dateOfBirth=\""+bean.getDateOfBirth()+"\";");
pw.println("employee.gender=\""+bean.getGender()+"\";");
pw.println("employee.isIndian="+bean.getIsIndian()+";");
pw.println("employee.basicSalary="+bean.getBasicSalary()+";");
pw.println("employee.panNumber=\""+bean.getPANNumber()+"\";");
pw.println("employee.aadharCardNumber=\""+bean.getAadharCardNumber()+"\";");
pw.println("employees["+i+"]=employee;");
i++;
}

randomAccessFile.close();

}
catch(Exception exception)
{
System.out.println(exception);
}
}

}