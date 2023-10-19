
<jsp:include page='/MasterPageTopSection.jsp'/>
<script>
function setLeftPanel()
{
sessionStorage.setItem("highlightPanel","Home");
}
window.addEventListener('load',setLeftPanel());
</script>
<h1>Welcome</h1>
<jsp:include page='/MasterPageBottomSection.jsp'/>