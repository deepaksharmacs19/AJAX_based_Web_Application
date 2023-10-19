<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tg' %>  
<tg:Module name='DESIGNATION'/>

<jsp:include page='/MasterPageTopSection.jsp'/>

<script src='/stylethree/js/DesignationDeleteForm.js'></script>

<script>
function retrieveData()
{
var xmlHttpRequest = new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status=200)
{
var designation=JSON.parse(this.responseText);

sessionStorage.setItem('code',designation.code);
sessionStorage.setItem('title',designation.title);

var messageHeading=document.getElementById("message");
messageHeading.innerHTML='Delete '+designation.title;

}
else {
window.location.href='Designations.jsp';
}
}
};

const queryString = window.location.search;
const searchParams = new URLSearchParams(queryString);
var code = searchParams.get('code');

var dataToSend="code="+code;
xmlHttpRequest.open('POST','confirmDeleteDesignation',true);
xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
xmlHttpRequest.send(dataToSend);
}


function goToDeleteDesignation()
{
var xmlHttpRequest = new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status=200)
{
var message=JSON.parse(this.responseText);
sessionStorage.setItem("data",JSON.stringify(message));
window.location.href='Notification.jsp';
}
else window.location.href='Designation.jsp';
}
};


var dataToSend="code="+sessionStorage.getItem('code');

xmlHttpRequest.open('POST','deleteDesignation',true);
xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
xmlHttpRequest.send(dataToSend);
}


window.addEventListener('load',retrieveData);
</script>

<h2>Designation (Delete Module)</h2>

<tg:FormID />

<input type='hidden' id='form_id' name='form_id' value='${form_id}'>

<h2 id='message'></h2><br>

<button type='submit' onclick='goToDeleteDesignation()'>yes</button>

<button type='Button' onclick='cancelDeletion()'>no</button>

<form id='cancelDeletionForm' action='/stylethree/Designations.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp'/>