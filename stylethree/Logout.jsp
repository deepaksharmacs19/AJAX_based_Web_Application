<html>
<head></head>
<body>
<script>
function logoutPage()
{
sessionStorage.removeItem('administrator');
window.location.href='LoginForm.jsp';
}
window.addEventListener('load',logoutPage());
</script>
</body>
</html>