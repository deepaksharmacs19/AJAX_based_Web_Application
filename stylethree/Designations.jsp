<jsp:include page='/MasterPageTopSection.jsp'/>

<script>

function setLeftPanel()
{
sessionStorage.setItem("highlightPanel","Designation");
}

window.addEventListener('load',setLeftPanel());

function populateDesignations()
{
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
var table=document.getElementById('DesignationsTable');
var body=table.getElementsByTagName('tbody')[0];


if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;
var designations=JSON.parse(responseData);

var row;
var cell1,cell2,cell3,cell4;
var j=1;
for(var i=0;i<designations.length;i++,j++)
{
row=document.createElement('tr');

cell1=document.createElement('td');
cell1.style.textAlign='right';
cell1.textContent=j;
cell1.style.fontWeight='bold'

cell2=document.createElement('td');
cell2.textContent=designations[i].title;
cell2.style.fontWeight='bold'

cell3=document.createElement('td');
cell3.style.textAlign='center';
cell3.style.fontWeight='bold'

var anchorElement=document.createElement('a');
anchorElement.href='/stylethree/DesignationEditForm.jsp?code='+designations[i].code;
anchorElement.textContent='Edit';
cell3.appendChild(anchorElement);

cell4=document.createElement('td');
cell4.style.textAlign='center';
cell4.style.fontWeight='bold'

var anchorElement=document.createElement('a');
anchorElement.href='/stylethree/ConfirmDeleteDesignation.jsp?code='+designations[i].code;
anchorElement.textContent='Delete';
cell4.appendChild(anchorElement);

row.appendChild(cell1);
row.appendChild(cell2);
row.appendChild(cell3);
row.appendChild(cell4);
table.appendChild(row);
}

}

}

};


xmlHttpRequest.open('POST','designations',true);
xmlHttpRequest.setRequestHeader("Context-Type","application/x-www-form-urlencoded");
xmlHttpRequest.send();
}

window.addEventListener('load',populateDesignations);
</script>

<h2>Designations</h2>
<table border='1' id='DesignationsTable'>
<thead>
<tr>
<th colspan='4' style='text-align:right;padding:5px'>
<a href='/stylethree/DesignationAddForm.jsp'>Add new designation</a>
</th>
</tr>
<tr>
<th style='width:60px;text-align:center'>S.No.</th>
<th style='width:200px;text-align:center'>Designation</th>
<th style='width:100px;text-align:center'>Edit</th>
<th style='width:200px;text-align:center'>Delete</th>
</tr>
</thead>
<tbody>

</tbody>
</table>

<jsp:include page='/MasterPageBottomSection.jsp'/>