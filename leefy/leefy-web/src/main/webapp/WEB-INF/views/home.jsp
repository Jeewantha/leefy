<!-- home.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
</head>
<body>
<h1>Hello Spring MVC 3!</h1>
<a href="<c:url value="/display?input=HelloWorldEcho" />">Click to Get Request Info</a>
<br/><br/>
<div id="result"></div>
</body>
</html>
<script type="text/javascript">
$(document).ready(function() {
 
    $.getJSON('<c:url value="extractJson?input=HelloWorldEcho" />', function(data) {
        $('#result').append('Result from ajax/json<br/>');
        $('#result').append('Name: ' + data.name);
        $('#result').append('<br/>');
        $('#result').append('Website: ' + data.website);
        $('#result').append('<br/>');
        $('#result').append('Input Parameter: ' + data.output);
    });
});
</script>