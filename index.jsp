<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>In</title>
</head>
<body>
<div align="center">
<i>
<u>
<h1  style="color:LightGreen">Company Share List</h1>
</u>
<h3>
<br/><br/>
<a href="company-entry" style="color:magenta" >Enlist new company</a>
</i>
</h3>

<h3>
<br/><br/>
<table border="2">
<tr style="background-color:orange;">
 <th style="color:blue">COMPANY ID</th>
  <th style="color:blue">COMPANY NAME</th>
   <th style="color:blue">SHAREPRICE</th>
     <th style="color:blue">Actions</th>
     </tr>
   <c:forEach items="${companyList}" var="companyshare">
   <tr style="background-color:yellow";>
    <td style="color:blue">${companyshare.companyId}</td>
    <td style="color:blue">${companyshare.companyName}</td>
    <td style="color:blue">${companyshare.sharePrice}</td>
     <td><h5>
     <a href="edit-sharePrice/${companyshare.companyId} style="color:magenta">Edit share price</a> 
     &nbsp;&nbsp;<a href="delete-company/${companyshare.companyId} style="color:magenta">Delete Company</a>
     </td></h5>
        </tr>
   </c:forEach>
</table>
</h3>
</div>
</body>
</html>