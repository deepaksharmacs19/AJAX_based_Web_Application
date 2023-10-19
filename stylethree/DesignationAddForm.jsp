<jsp:include page='/MasterPageTopSection.jsp'/>
<script>


function forwardRequestToAddDesignation()
{
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;

var dataToSend=JSON.parse(responseData);
sessionStorage.setItem('data',JSON.stringify(dataToSend));
window.location.href='Notification.jsp?';
}
else {
var errorSpan=document.getElementById('error');
errorSpan.innerHTML=this.responseText+"<br>";
//window.location.href='';
}
}

};


var title = document.getElementById("title").value;
var dataToSend = "title=" + encodeURI(title);

xmlHttpRequest.open('POST','addDesignation',true);
xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
xmlHttpRequest.send(dataToSend);
}

</script>





<script src='/stylethree/js/DesignationAddForm.js'></script>
<h2>Designation (Add Module)</h2>
<span class='error' id='error'>
</span>


Designation
<input type='text' id='title' name='title' maxlength='35' size='36'>
<span id='titleErrorSection' class='error'></span><br>
<button type='submit' onclick='forwardRequestToAddDesignation()'>Add</button>
<button type='Button' onclick='cancelAddition()'>Cancel</button>

<form id='cancelAdditionForm' action='/stylethree/Designations.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp'/>