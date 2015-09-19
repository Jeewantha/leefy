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
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<html>
<head>
	<title><spring:message code="PAGE.LOGIN.TITLE"/></title>
	<jsp:include page="includes.jsp" />
	<script type="text/javascript">
		if (Ext.BLANK_IMAGE_URL.substr(0, 5) != 'data:') {
			Ext.BLANK_IMAGE_URL = '<c:url value="/resources/lib/ext-3.3.1/resources/images/default/s.gif" />';
		}
		var loginUrl = '${ctx}/login';
		var defLoginUrl = '${ctx}/j_spring_security_check';
		var homeUrl = '${ctx}';
		var loadUrl = '${ctx}/load';
		var addUrl = '${ctx}/add';
		var jsonpreq = '${ctx}/extractJson';
		var logoutUrl='${ctx}/j_spring_security_logout';
		var currentLocale='${pageContext.response.locale}';
		
		var loginError ='<spring:message code="USER.LOGIN.FAILURE.ERROR"/>';

		var loginWelcomeTitle ="<spring:message code='PAGE.LOGIN.WELCOME.WINDOW.TITLE'/>";
		var loginSigninFormTitle ="<spring:message code='PAGE.LOGIN.SIGNIN.FORM.TITLE'/>";
		var loginSigninFormLableLogin = "<spring:message code='PAGE.LOGIN.SIGNIN.FORM.LABEL.LOGIN'/>";		
		var loginSigninFormLablePassword = "<spring:message code='PAGE.LOGIN.SIGNIN.FORM.LABEL.PASSWORD'/>";		
		var loginSigninFormLableRememberMe = "<spring:message code='PAGE.LOGIN.SIGNIN.FORM.LABEL.REMEMBERME'/>";		
		var loginSigninFormButtonLogin = "<spring:message code='PAGE.LOGIN.SIGNIN.FORM.BUTTON.LOGIN'/>";		
		var loginSigninFormButtonReset = "<spring:message code='PAGE.LOGIN.SIGNIN.FORM.BUTTON.RESET'/>";		
		var loginSignupFormLabelTitle = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.LABEL.FORM.TITLE'/>";
		var loginSignupFormLableUsername = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.LABEL.FORM.USERNAME'/>";
		var loginSignupFormLableEmail = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.LABEL.FORM.EMAIL'/>";
		var loginSignupFormLableConfirmEmail = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.LABEL.FORM.CONFIRMEMAIL'/>";
		var loginSignupFormLablePassword = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.LABEL.FORM.PASSWORD'/>";
		var loginSignupFormLableCounrty = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.LABEL.FORM.COUNTRY'/>";
		var loginSignupFormLableConfirmPassword = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.LABEL.FORM.CONFIRMPASSWORD'/>";
		var loginSignupFormLableBirthday = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.LABEL.FORM.BIRTHDAY'/>";
		var loginSignupFormButtonSignup = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.BUTTON.SIGNUP'/>";
		var loginSignupFormButtonReset = "<spring:message code='PAGE.LOGIN.SIGNUP.FORM.BUTTON.RESET'/>";
		
	</script>	
	<script type="text/javascript" src="<c:url value="/resources/js/leefy-login.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/flag-icon-css-master/css/flag-icon.css" />">
</head>
<body>

	<div style="height:390;background:#F3FAB6;" align="center"">
	</div>
	<div style="height:200;background:#CBE32D;" align="center"">
	</div>

</body>
</html>
