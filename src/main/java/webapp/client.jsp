<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Add new Client</title>
</head>

<form method="POST" action='ClientController' name="frmAddClient">
    Client ID : <input type="text" readonly="readonly" name="clientId"
                     value="<c:out value="${client.clientId}" />" /> <br />
    First Name : <input
        type="text" name="firstName"
        value="<c:out value="${client.firstName}" />" /> <br />
    Second Name : <input
        type="text" name="secondName"
        value="<c:out value="${client.secondName}" />" /> <br />
    Last Name : <input
        type="text" name="lastName"
        value="<c:out value="${user.lastName}" />" /> <br />
   <input type="submit" value="Submit" />
</form>
</body>
</html>