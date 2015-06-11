<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Forex Trader Demo</title>
    <script> var baseURL = "${pageContext.request.contextPath}"</script>
    <script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
    <script src="<c:url value="/resources/script.js" />"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
    <h1>Forex Trader Demo</h1>
    <h2>Balance: <span id="balance">${balance}</span> UAH</h2>
    <h2>Dollars purchased: <span id="dollars">${dollars}</span> USD</h2>
    <h2>Exchange rate: <span id="rate">${rate}</span> UAH/USD     <span id="trend">${trend}</span></h2>
    <br />
    <br />
    <table>
        <tr>
            <td>Amount of USD to buy:</td>
            <td>
                <input id="dollarsToBuy" type="text" name="amount"/>
            </td>
            <td>
                <button id="buyButton">Buy</button>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td>Amount of USD to sell:</td>
            <td>
                <input id="dollarsToSell" type="text" name="amount"/>
            </td>
            <td>
                <button id="sellButton">Sell</button>
            </td>
        </tr>
    </table>
    <br />
    <p>You can buy now max: <span id="max">${max}</span> USD</p>
    <p id="console"></p>
    <br />
    <p>
        <button id="reset">Reset application</button>
    </p>
</body>
</html>