<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is home page</title>
</head>
<body>
	<!-- 
	<form name = "logoutForm"  action="<c:url value='j_spring_security_logout' />" method='POST'>
	 -->
	<form name = "logoutForm"  action="j_spring_security_logout" method='POST'>
		<input value="logout" type="submit"/>
	</form>
	
</body>
</html>