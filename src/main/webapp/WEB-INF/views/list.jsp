<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>
</head>
<body>
    <h1>Clientes Cadastrados</h1>
    <p>${sucesso}</p>
    <p>${falha }</p>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>E-mail</th>
        </tr>
        <tbody>
	    <c:forEach items="${users }" var="users">
	        <tr>
	            <td>${users.id }</td>
	            <td>${users.name }</td>
	            <td>${users.email }</td>
	            <td><a href="${s:mvcUrl('UC#editar').arg(0, users.id).build()}">Editar</a></td>
	            <td><a href="${s:mvcUrl('UC#excluir').arg(0, users.id).build()}">Excluir</a></td>
	        </tr>
	    </c:forEach>
        </tbody>
    </table>
</body>
</html>