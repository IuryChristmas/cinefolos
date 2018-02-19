<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar cadastro</title>
</head>
<body>
<form:form action="${s:mvcUrl('UC#alterar').build() }" method="post" commandName="user" enctype="multipart/form-data">
	    <input type="hidden" name="id" id="${user.id }" value="${user.id }" />
	    <div>
           <label>Nome</label>
           <form:input path="name" value="${user.name }"/>
           <form:errors path="name" />
        </div>
        <div>
        <label>E-mail</label>
        <form:input rows="10" cols="20" path="email" value="${user.email }" />
        <form:errors path="email" />
    </div>
	    <button type="submit">Salvar</button>	    
</form:form>
</body>
</html>