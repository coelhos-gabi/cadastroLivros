<%--
  Created by IntelliJ IDEA.
  User: gabrielacoelho
  Date: 26/07/2022
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Cadastro</title>
    </head>
    <body>
        <fieldset>
            <legend>Dados Livro</legend>
            <form action="registration-servlet/cadastrar-livro" method="post">
                <div>
                    <label for="idTitle">Título:</label>
                    <input type="text" id="idTitle" name="title">
                </div>
                <div>
                    <label for="idAuthor">Autor:</label>
                    <input type="text" id="idAuthor" name="author">
                </div>
                <div>
                    <label for="idPublisher">Editora:</label>
                    <input type="text" id="idPublisher" name="publisher">
                </div>
                <div>
                    <label for="idPages">Páginas:</label>
                    <input type="text" id="idPages" name="pages">
                </div>
                <div>
                    <label for="idYear">Ano de publicação:</label>
                    <input type="text" id="idYear" name="year">
                </div>
                <input type="submit" value="Enviar">
            </form>
        </fieldset>
    </body>
</html>
