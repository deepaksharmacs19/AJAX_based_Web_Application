function Employee()
{
this.employeeId="";
this.name="";
this.designationCode=0;
this.designation="";
this.dateOfBirth="";
this.gender="";
this.isIndian=true;
this.basicSalary=0;
this.panNumber="";
this.aadharCardNumber="";
}
var selectedRow=null;
var employees=[];
var employee=new Employee();
employee.employeeId="A2";
employee.name="Raju"
employee.designationCode=5;
employee.designation="Cook";
employee.dateOfBirth="07/06/2011";
employee.gender="M";
employee.isIndian=true;
employee.basicSalary=5000.00;
employee.panNumber="eiw323";
employee.aadharCardNumber="323212";
employees[0]=employee;
var employee=new Employee();
employee.employeeId="A1";
employee.name="Toy Singh"
employee.designationCode=1;
employee.designation="MasterHead";
employee.dateOfBirth="05/06/2000";
employee.gender="M";
employee.isIndian=true;
employee.basicSalary=20000.00;
employee.panNumber="abc1234";
employee.aadharCardNumber="123455677";
employees[1]=employee;
function selectEmployee(row,employeeId)
{
if(selectedRow==row) return;
if(selectedRow!=null)
{
selectedRow.style.background="white";
selectedRow.style.color="black";
}
row.style.background="#7C7B7B";
row.style.color="white";
selectedRow=row;
var i;
for(i=0;i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
break;
}
}
var emp=employees[i];
document.getElementById("detailPanel_employeeId").innerHTML=emp.employeeId;
document.getElementById("detailPanel_name").innerHTML=emp.name;
document.getElementById("detailPanel_designation").innerHTML=emp.designation;
document.getElementById("detailPanel_gender").innerHTML=emp.gender;
document.getElementById("detailPanel_dateOfBirth").innerHTML=emp.dateOfBirth;
if(emp.isIndian)
{
document.getElementById("detailPanel_isIndian").innerHTML="Yes";
}
else
{
document.getElementById("detailPanel_isIndian").innerHTML="No";
}
document.getElementById("detailPanel_basicSalary").innerHTML=emp.basicSalary;
document.getElementById("detailPanel_panNumber").innerHTML=emp.panNumber;
document.getElementById("detailPanel_aadharCardNumber").innerHTML=emp.aadharCardNumber;
}