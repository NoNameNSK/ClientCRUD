<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Clients</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Client Id</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Last Name</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td><c:out value="${client.clientId}" /></td>
            <td><c:out value="${client.firstName}" /></td>
            <td><c:out value="${client.secondName}" /></td>
            <td><c:out value="${client.lastName}" /></td>
            <td><a href="/controller?action=edit&clientId=<c:out value="${client.clientId}"/>">Update</a></td>
            <td><a href="/controller?action=delete&clientId=<c:out value="${client.clientId}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="/controller?action=insert">Add Client</a></p>
</body>
</html>