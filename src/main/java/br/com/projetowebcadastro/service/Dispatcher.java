package br.com.projetowebcadastro.service;

import br.com.projetowebcadastro.bo.IBookBusinessObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Dispatcher implements DispatcherI {
    public void dispatchForward(HttpServletRequest req, HttpServletResponse resp, IBookBusinessObject bookBusinessObject)
            throws ServletException, IOException {

        var bookList = bookBusinessObject.findAll();
        req.setAttribute("bookList", bookList);

        var dispatcher = req.getRequestDispatcher("/livros-cadastrados.jsp");
        dispatcher.forward(req,resp);
    }
}
