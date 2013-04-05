<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>

<title>Weather Info</title>

</head>

<body>

<h1>Weather Info</h1>

<table>

<tr>

<td>City Name:</td>

<td><c:out value="${city.cityName}" /></td>

</tr>

<tr>

<td>State :</td>

<td><c:out value="${city.state}" /></td>

</tr>

<tr>

<td>Temperature :</td>

<td><c:out value="${city.tempInF}" /> F</td>

</tr>

</table>

</body>

</html>