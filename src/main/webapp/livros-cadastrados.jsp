<%--
  Created by IntelliJ IDEA.
  User: gabrielacoelho
  Date: 26/07/2022
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Livros Cadastrados</title>
</head>
<body>
    <h1>Livros cadastrados</h1>
        
    <table border="solid">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Autor</th>
            <th>Editora</th>
            <th>Páginas</th>
            <th>Ano de Publicação</th>
            <th> </th>
            <th> </th>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.publisher}</td>
                <td>${book.pages}</td>
                <td>${book.year}</td>
                <td>
                    <a href=
                            "${pageContext.request.contextPath}/registration-servlet/preparar-alteracao?id=<c:out value='${book.id}' />">Alterar</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/registration-servlet/remover-livro?id=<c:out value='${book.id}' />">Remover</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/cadastro-livro.jsp">Cadastrar livro</a>
</body>
</html>
