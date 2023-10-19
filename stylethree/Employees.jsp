<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tg' %>  
<tg:Module name='EMPLOYEE'/>

<jsp:useBean id='employeeBean' class='com.thinking.machines.hr.beans.EmployeeBean' scope='request'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<link rel='stylesheet' type='text/css' href='/styletwo/css/employees.css'>
<h4>Employees</h4>

<script src='/styletwo/js/Employees.js'></script>

<div class='employeeGrid'>
<table border='1' id='employeesGridTable'>
<thead>
<tr >
<th colspan='6' class='employeeGridHeader'>
<a href='/styleone/getEmployeeAddForm'>Add Employee</a>
</th>
</tr>
<tr>
<th class='employeeGridSNOColumnTitle'>S.No.</th>
<th class='employeeGridIdColumnTitle'>Id.</th>
<th class='employeeGridNameColumnTitle'>Name</th>
<th class='employeeGridDesignationColumnTitle'>Designation</th>
<th class='employeeGridEditColumnTitle'>Edit</th>
<th class='employeeGridDeleteColumnTitle'>Delete</th>
</tr>
</thead>
<tbody>


<tr style='cursor:pointer' >
<td style='text-align:right' placeHolderId='serialNumber'></td>
<td placeHolderId='employeeId'></td>
<td placeHolderId='name'></td>
<td placeHolderId='designation'></td>
<td style='text-align:center' placeHolderId='editOption'></td>
<td style='text-align:center' placeHolderId='deleteOption'></td>

</tr>


</tbody>
</table>
</div>

<div style='height:23vh;margin-left:5px;margin-right:5px;margin-bottom:px;margin-top:5px;overflow;scroll;padding:5px;border:1px solid black'>
<label style='background-color:gray;color:white'>Details</label>
<table border='0' width="100%">
<tr>
<td>Employee Id : <span id='detailPanel_employeeId'  style='margin-right:30px'</span></td>
<td>Name : <span id='detailPanel_name'  style='margin-right:30px'</span></td>
<td>Designation : <span id='detailPanel_designation'  style='margin-right:30px'</span></td>
</tr>
<tr>
<td>Date of birth : <span id='detailPanel_dateOfBirth'  style='margin-right:30px'</span></td>
<td>Gender : <span id='detailPanel_gender'  style='margin-right:30px'</span></td>
<td>Is Indian : <span id='detailPanel_isIndian'  style='margin-right:30px'</span></td>
</tr>
<tr>
<td>Basic Salary : <span id='detailPanel_basicSalary'  style='margin-right:30px'</span></td>
<td>Pan number : <span id='detailPanel_panNumber'  style='margin-right:30px'</span></td>
<td>Aadhar card number : <span id='detailPanel_aadharCardNumber'  style='margin-right:30px'</span></td>
</tr>
</table>
</div>
</div>
<jsp:include page='/MasterPageBottomSection.jsp'/>