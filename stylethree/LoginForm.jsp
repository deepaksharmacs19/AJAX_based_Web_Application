<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>

<link rel='stylesheet' type='text/css' href='/stylethree/css/styles.css'>

<script>

function login()
{
var spanError=document.getElementById('error');
spanError.innerHTML="";

var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=JSON.parse(this.responseText);

sessionStorage.setItem('administrator',JSON.stringify(responseData));
window.location.href = "index.jsp";
}
else 
{
var responseData=this.responseText;
var spanError=document.getElementById('error');
spanError.innerHTML=responseData;
}
}

};

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

   var dataToSend = "username=" + encodeURI(username) + "&password=" + encodeURI(password);

    xmlHttpRequest.open('POST', 'login', true);
    xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttpRequest.send(dataToSend);
}


</script>

</head>

<body>


<div style='margin: 5px; width: 90vw; height: auto; display: flex; align-items: center;'>
  <img src='/styleone/images/logo.png' style='margin-right: 10px;'>

<span style='font-size: 30pt;margin-top:30px'>Thinking Machines</span>
</div>

<span style='display:grid; place-items:center; margin:5px;padding:20px;font-size:20pt'>
Administrator</span>

<div style='display:grid; place-items:center; margin-left:auto;margin-right:auto;padding:20px;width:20%;border:1px solid black'>

<table>
<span style='color:red' id='error'>

</span>

<tr>
<td>Username: </td>

<td><input type='text' id='username' name='username'></td>


</tr>
<tr>
<td>
Password: 
</td>

<td><input type='password' id='password' name='password'></td>

</tr>
<tr>
<td></td>
<td><button type="submit" style='display:block' onclick='login()'>Login</button>

</td>
</tr>

</table>



</div>

<!-- Main container ends here -->
</body>
</html>