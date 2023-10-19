package com.thinking.machines.hr.beans;
import java.util.*;
import java.math.*;

// I have changed EmployeeDTO and datatypes of dob, basicSalary.

public class EmployeeBean implements java.io.Serializable,Comparable<EmployeeBean>
{
private String employeeId;
private String name;
private int designationCode;
private String designation;
private String dateOfBirth;
private String gender;
private boolean isIndian;
private String basicSalary;
private String panNumber;
private String aadharCardNumber;

public EmployeeBean()
{
this.employeeId="";
this.name="";
this.designationCode=0;
this.designation="";
this.dateOfBirth="";
this.gender="";
this.isIndian=false;
this.basicSalary="";
this.panNumber="";
this.aadharCardNumber="";
}
public void setEmployeeId(java.lang.String employeeId)
{
this.employeeId=employeeId;
}
public java.lang.String getEmployeeId()
{
return this.employeeId;
}
public void setName(java.lang.String name)
{
this.name=name;
}
public java.lang.String getName()
{
return this.name;
}
public void setDesignationCode(int designationCode)
{
this.designationCode=designationCode;
}
public int getDesignationCode()
{
return this.designationCode;
}
public void setDesignation(java.lang.String designation)
{
this.designation=designation;
}
public java.lang.String getDesignation()
{
return this.designation;
}

public boolean isMale()
{
return gender.equals("M");
}

public boolean isFemale()
{
return gender.equals("F");
}

public void setDateOfBirth(String dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public String getDateOfBirth()
{
return this.dateOfBirth;
}
public void setGender(java.lang.String gender)
{
this.gender=gender;
}
public java.lang.String getGender()
{
return this.gender;
}
public void setIsIndian(boolean isIndian)
{
this.isIndian=isIndian;
}
public boolean getIsIndian()
{
return this.isIndian;
}
public void setBasicSalary(String basicSalary)
{
this.basicSalary=basicSalary;
}
public String getBasicSalary()
{
return this.basicSalary;
}
public void setPANNumber(java.lang.String panNumber)
{
this.panNumber=panNumber;
}
public java.lang.String getPANNumber()
{
return this.panNumber;
}
public void setAadharCardNumber(java.lang.String aadharCardNumber)
{
this.aadharCardNumber=aadharCardNumber;
}
public java.lang.String getAadharCardNumber()
{
return this.aadharCardNumber;
}
public int hashCode()
{
return employeeId.hashCode();
}
public boolean equals(Object object)
{
if(!(object instanceof EmployeeBean)) return false;
EmployeeBean employee=(EmployeeBean)object;
return this.employeeId.equalsIgnoreCase(employee.employeeId);
}
public int compareTo(EmployeeBean employee)
{
return this.employeeId.compareTo(employee.employeeId);
}
}