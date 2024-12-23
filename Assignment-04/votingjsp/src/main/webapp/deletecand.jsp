<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dcb" class="com.sunbeam.beans.DeleteCandidateBean"></jsp:useBean>
	<jsp:setProperty property="id" name="dcb" param="id"/>
	${dcb.deleteCandidate()}
	<jsp:forward page="result.jsp">
	<jsp:param value="${dcb.message}" name="dcbMessage"/>
	</jsp:forward>
</body>
</html>