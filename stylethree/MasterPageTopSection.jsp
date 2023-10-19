<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>

<link rel='stylesheet' type='text/css' href='/stylethree/css/styles.css'>

<script>

window.onload=function check()
{
var data=(sessionStorage.getItem('administrator'));

if(data==null)
{
window.location.href = "LoginForm.jsp";
}

var admin=JSON.parse(data);
var adminText=document.getElementById('uname');
adminText.innerHTML=admin.username;
}


</script>


</head>
<body>



<!-- Main container starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<img src='/styleone/images/logo.png' class='logo'>

<div class='brand-name'>Thinking Machines
<a href='/stylethree/Logout.jsp' style='float:right;margin-right:20px;font-size:20pt'>Logout</a>

<img src='/stylethree/images/admin.png' style='float:right;margin-right:100px;width:50px'>
<span style='float:right;margin-right:10px'  id='uname'></span>
</div>



</div> <!-- header ends  here -->
<!-- content section starts  here -->
<div class='content'>
<!-- left panel starts  here -->


<div class='content-left-panel'>

</div>

<script>
window.addEventListener('load', panelSetter);

function panelSetter() {
    var leftPanel = sessionStorage.getItem('highlightPanel');
    var contentLeftPanel = document.querySelector('.content-left-panel');
    
    // Function to create an anchor element and set its properties
    function createAnchor(href, text) {
        var anchor = document.createElement('a');
        anchor.href = href;
        anchor.textContent = text;
anchor.style.fontWeight='bold';
        return anchor;
    }

    // Function to create a text element
    function createText(text) {
        var textNode = document.createTextNode(text);
        return textNode;
    }

    // Clear the content inside the contentLeftPanel
    contentLeftPanel.innerHTML = '';

    if (leftPanel !== 'Designation') {
        contentLeftPanel.appendChild(createAnchor('/stylethree/Designations.jsp', 'Designations'));
    } else {
         var noDesignationElement = document.createElement('b');
    noDesignationElement.textContent = 'Designations';
    contentLeftPanel.appendChild(noDesignationElement);
    }

    contentLeftPanel.appendChild(document.createElement('br'));

    if (leftPanel !== 'Employee') {
        contentLeftPanel.appendChild(createAnchor('/stylethree/Employees.jsp', 'Employees'));
    } else {
 var noEmployeesElement = document.createElement('b');
    noEmployeesElement.textContent = 'Employees';
    contentLeftPanel.appendChild(noEmployeesElement);
    }

    contentLeftPanel.appendChild(document.createElement("br"));
    contentLeftPanel.appendChild(document.createElement("br"));
    

    if (leftPanel !== 'Home') {
        contentLeftPanel.appendChild(createAnchor('/stylethree/index.jsp', 'Home'));
    }
}

</script>

<!-- left panel ends here -->
<!-- right panel starts  here -->
<div class='content-right-panel'>
