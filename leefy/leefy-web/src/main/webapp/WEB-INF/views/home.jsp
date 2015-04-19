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