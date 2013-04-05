<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>City Input</title>
</head>
<body>
<h2>City Weather App</h2>
<form:form method="post" action="cityInfo.do" commandName="city">
 
    <table>
    <tr>
        <td><form:label path="zipCode">City Zip Code</form:label></td>
        <td><form:input path="zipCode" /></td>
    </tr>
	<tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table> 
     
</form:form>
</body>
</html>    