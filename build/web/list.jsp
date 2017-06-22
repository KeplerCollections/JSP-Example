<%@page import="java.util.List"%>
<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="index.jsp" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <table border="1">
            <tr>
                <td><b>ID</b></td>
                <td><b>Name</b></td>
                <td><b>Email</b></td>
                <td><b>Password</b></td>
                <td><b>Action</b></td>
            </tr>
            <%
                List<User> values = (List<User>) request.getAttribute("values");

                for (int i = 0; i < values.size(); i++) {
                    final User user = values.get(i);
        //            out.println(user.getId());
        //            out.println(user.getName());
        //            out.println(user.getEmail());
        //            out.println(user.getPass());   
%>

            <tr>
                <td> <%=user.getId()%></td>
                <td><%=user.getName()%> </td>
                <td> <%=user.getEmail()%></td>
                <td> <%=user.getPass()%></td>
                <td> <a href="ControllerServlet?value=4">Edit</a>&nbsp;&nbsp;&nbsp;<a href="ControllerServlet?value=3&id=<%=String.valueOf(user.getId())%>" >Delete</a></td>
            </tr>

            <%
                }
            %>

        </table>
    </body>
</html>
