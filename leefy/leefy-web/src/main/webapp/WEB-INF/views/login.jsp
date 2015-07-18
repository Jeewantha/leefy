<!-- 

  Leefy is a simple social network to narrow the gap between people speaking different
  languages and to aid the language learning process.
    Copyright (C) 2015  Jeewantha Samaraweera

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Login</title>
	<jsp:include page="includes.jsp" />
	<script type="text/javascript">
		var loginUrl = '${ctx}/app/login.do';
		var defLoginUrl = '${ctx}/j_spring_security_check';
		var homeUrl = '${ctx}';
	</script>	
	<script type="text/javascript" src="<c:url value="/resources/js/leefy-login.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/styles.css" />">
</head>
<body>
</body>
</html>
