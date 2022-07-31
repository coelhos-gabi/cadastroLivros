<%--
  Created by IntelliJ IDEA.
  User: gabrielacoelho
  Date: 27/07/2022
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Alteração de Livro</title>
  </head>
  <body>
    <fieldset>
      <legend>Dados Livro</legend>
      <form action="alterar-livro" method="post">
        <div>
          <input type="hidden" name="id" value="${book.id}">
        </div>
        <div>
          <label for="idTitle">Título:</label>
          <input type="text" id="idTitle" name="title" value="${book.title}">
        </div>
        <div>
          <label for="idAuthor">Autor:</label>
          <input type="text" id="idAuthor" name="author" value="${book.author}">
        </div>
        <div>
          <label for="idPublisher">Editora:</label>
          <input type="text" id="idPublisher" name="publisher" value="${book.publisher}">
        </div>
        <div>
          <label for="idPages">Páginas:</label>
          <input type="text" id="idPages" name="pages" value="${book.pages}">
        </div>
        <div>
          <label for="idYear">Ano de publicação:</label>
          <input type="text" id="idYear" name="year" value="${book.year}">
        </div>
        <input type="submit" value="Enviar">
      </form>
    </fieldset>
  </body>
</html>
