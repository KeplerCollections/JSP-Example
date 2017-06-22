<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ include file="index.jsp" %>  
<h3>Add Record</h3>  
<form action="ControllerServlet" method="post">
    <input type="hidden" name="value" value="1"/><br/><br/>   
    FullName:<input type="text" name="name"/><br/><br/> 
    Email Id:<input type="text" name="email"/><br/><br/>  
    Password:<input type="password" name="password"/><br/><br/>  
    <input type="submit" value="Add" />
</form>  
