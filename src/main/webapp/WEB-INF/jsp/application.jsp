<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Forex Trader Demo</title>
</head>
<body>
    <h1>Forex Trader Demo</h1>
    <h2>Balance: ${balance} UAH</h2>
    <h2>Dollars purchased: $${dollars}</h2>
    <h2>Exchange rate: ${rate} UAH/USD</h2>
    <br />
    <br />
    <form:form method="post" modelAttribute="dollars" commandName="dollars">
        <table>
            <tr>
                <td>Amount of USD to buy</td>
                <td><form:input path="amount"/></td>
                <td>
                    <input type="submit" value="Buy"/>
                </td>
            </tr>
        </table>
    </form:form>

</body>
</html>