<jsp:include page='/MasterPageTopSection.jsp'/>

<script>
function populateData()
{
var jsonData = JSON.parse(sessionStorage.getItem('data'));

var headingElement=document.getElementById('heading');
headingElement.innerHTML=jsonData.heading;

var messageSpan=document.getElementById('message');
messageSpan.innerHTML=jsonData.message;

if(jsonData.generateButtons)
{
var tableForButtons=document.getElementById('buttonTable');
var tableRow=document.createElement("tr");

var tableData1=document.createElement("td");
var button1=document.createElement('button');
button1.textContent=jsonData.buttonOneText;
button1.onclick=function(){
window.location.href=jsonData.buttonOneAction;
}
tableRow.appendChild(button1);

if(jsonData.generateTwoButtons)
{
var button2=document.createElement('button');
button2.textContent=jsonData.buttonTwoText;
button2.onclick=function(){
window.location.href=jsonData.buttonTwoAction;
}
tableRow.appendChild(button2);
}

tableForButtons.appendChild(tableRow);
}// generateButtons ends here

}

window.addEventListener('load',populateData);
</script>

<h2 id='heading'></h2>
<span id='message'></span>
<br>  

<table id='buttonTable'>
</table>


<jsp:include page='/MasterPageBottomSection.jsp'/>