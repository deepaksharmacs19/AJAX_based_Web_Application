<jsp:include page='/MasterPageTopSection.jsp'/>

<script src='/stylethree/js/DesignationEditForm.js'></script>

<script>
function setLeftPanel()
{
sessionStorage.setItem("highlightPanel","Designation");
}

function executeFirst()
{
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200){
var titleTextBox=document.getElementById("title");

var designation=JSON.parse(this.responseText);
titleTextBox.value=designation.title;
sessionStorage.setItem('title',designation.title);
}
else {
alert(this.responseText);
}
}

};

const queryString = window.location.search;
const searchParams = new URLSearchParams(queryString);
var code = searchParams.get('code');
sessionStorage.setItem("code",code);
var dataToSend="code="+code;

xmlHttpRequest.open('POST','editDesignation',true);
xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
xmlHttpRequest.send(dataToSend);
}

window.addEventListener('load',setLeftPanel());
window.addEventListener('load',executeFirst());

function goToUpdateDesignation()
{
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200){
var data=JSON.parse(this.responseText);
sessionStorage.setItem("data",JSON.stringify(data));
window.location.href='Notification.jsp';
}
else {
alert(this.responseText);
}
}

};

const queryString = window.location.search;
const searchParams = new URLSearchParams(queryString);
var code = searchParams.get('code');

var title=document.getElementById('title').value;
var dataToSend="code="+code+"&title="+encodeURI(title);

xmlHttpRequest.open('POST','updateDesignation',true);
xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
xmlHttpRequest.send(dataToSend);
}

</script>

<h2>Designation (Edit Module)</h2>

<span class='error' id='error'>
</span>

Designation

<tg:FormID />

<input type='text' id='title' name='title' value=''>

<span id='titleErrorSection' class='error'></span><br>
<button type='Button' onclick='goToUpdateDesignation()'>Update</button>
<button type='Button' onclick='cancelEdition()'>Cancel</button>

<form id='cancelEditionForm' action='/stylethree/Designations.jsp'>
</form>

<jsp:include page='/MasterPageBottomSection.jsp'/>