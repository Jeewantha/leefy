<!-- display.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<strong><c:out value="Remote Address: ${RemoteAddress}"></c:out></strong><br/>
<strong><c:out value="Accept ${HeaderAccept}"></c:out></strong><br/>
<strong><c:out value="Accept-Encoding: ${HeaderAcceptEncoding}"></c:out></strong><br/>
<strong><c:out value="Accept-Charset: ${HeaderAcceptCharset}"></c:out></strong><br/><br/>
<strong><c:out value="Input Parameter: ${Output}"></c:out></strong><br/>
 
<br/>
<br/>
<br/>
<a href="<c:url value="/" />">Home</a>
 
</body>
</html>