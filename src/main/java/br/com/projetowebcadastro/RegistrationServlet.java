package br.com.projetowebcadastro;

import br.com.projetowebcadastro.bo.IBookBusinessObject;
import br.com.projetowebcadastro.factory.BookFactory;
import br.com.projetowebcadastro.service.DispatcherI;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/registration-servlet/*")
public class RegistrationServlet extends HttpServlet {
    private final IBookBusinessObject bookBusinessObject;
    private final DispatcherI dispatcherI;

    @Inject
    public RegistrationServlet(IBookBusinessObject ibookBusinessObject, DispatcherI iDispatcher) {
        this.bookBusinessObject = ibookBusinessObject;
        this.dispatcherI = iDispatcher;
    }

    @Override
    public void init() {
        System.out.println("Iniciando...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        switch (path) {
            case "/cadastrar-livro" -> doPost(req, resp);
            case "/preparar-alteracao" -> prepareAlteration(req, resp);
            case "/livros-cadastrados" -> doGet(req, resp);
            case "/remover-livro" -> doDelete(req, resp);
            case "/alterar-livro" -> doPut(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var book = BookFactory.createBook(req);

        bookBusinessObject.save(book);
        dispatcherI.dispatchForward(req,resp,bookBusinessObject);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        dispatcherI.dispatchForward(req,resp,bookBusinessObject);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");

        var bookEdited = BookFactory.createBook(req);
        bookEdited.setId(Integer.valueOf(id));

        bookBusinessObject.update(bookEdited);

        dispatcherI.dispatchForward(req,resp,bookBusinessObject);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var idInserido = req.getParameter("id");

        bookBusinessObject.remove(idInserido);

        dispatcherI.dispatchForward(req,resp,bookBusinessObject);
    }

    public void prepareAlteration(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        var bookSaved = bookBusinessObject.findById(id);

        req.setAttribute("book", bookSaved);

        var dispatcher = req.getRequestDispatcher("/editar-livro.jsp");
        dispatcher.forward(req,resp);
    }

}
