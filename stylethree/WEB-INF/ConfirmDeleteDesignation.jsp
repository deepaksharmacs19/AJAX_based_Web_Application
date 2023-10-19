<jsp:useBean id='designationBean' class='com.thinking.machines.hr.beans.DesignationBean' scope='request'/>
  

<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>
<script src='/styletwo/js/DesignationDeleteForm.js'></script>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>

</head>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<img src='/styleone/images/logo.png' class='logo'>
<div class='brand-name'>Thinking Machines</div>
</div> <!-- header ends  here -->
<!-- content section starts  here -->
<div class='content'>
<!-- left panel starts  here -->
<div class='content-left-panel'>
<b>Designations<b><br>
<a href='/styletwo/Employees.jsp'>Employees</a>
<br><br>
<a href='/styletwo/index.html'>Home</a>
</div>
<!-- left panel ends here -->
<!-- right panel starts  here -->
<div class='content-right-panel'>
<h2>Designation (Delete Module)</h2>
<form method='post' action='/styletwo/DeleteDesignation.jsp' onsubmit='return validateForm(this)'>
Delete ${designationBean.title}<br>
<button type='submit'>yes</button>
<button type='Button' onclick='cancelDeletion()'>no</button>
</form>
</div>
<!-- right panel ends here -->
</div>
<!-- content section ends  here -->
<!-- footer starts here -->
<div class='footer'>
&copy;Thinking Machines 2020
<!-- footer ends here -->
</div>
<!-- Main container ends here -->
<form id='cancelDeletionForm' action='/styletwo/Designations.jsp'>
</form>
</body>
</html>