<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h2> Java Beans</h2>
	<div>
		<%-- create bean object --%>
		<jsp:useBean id="cb2" class="com.sunbeam.beans.RegistrationBean"/>
		<%-- set bean field values from req parameters --%>
		<jsp:setProperty name="cb2" property="firstname" param="firstname" />
		<jsp:setProperty name="cb2" property="lastname" param="lastname" />
		<jsp:setProperty name="cb2" property="email" param="email" />
		<jsp:setProperty name="cb2" property="passwd" param="passwd" />
		<jsp:setProperty name="cb2" property="dob"  param="dob" />
		
		
	
		 
		 
		 
		 ${cb2.registerU() }
		 
		 <c:choose>
		<c:when test="${cb2.count == 1}">
			success: ${count}
		</c:when>
		<c:otherwise>
			failure: ${count}
		</c:otherwise>
	</c:choose>
		
		 
	</div>
	
</body>
</html>

