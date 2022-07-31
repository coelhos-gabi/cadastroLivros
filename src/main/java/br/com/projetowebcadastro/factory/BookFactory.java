package br.com.projetowebcadastro.factory;

import br.com.projetowebcadastro.model.Book;

import javax.servlet.http.HttpServletRequest;

public class BookFactory {

    public static Book createBook(HttpServletRequest req){
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String pages = req.getParameter("pages");
        String year = req.getParameter("year");

        Integer bookPages = null;
        Integer bookYear = null;
        if (!(pages.isEmpty() && year.isEmpty())){
            bookPages = Integer.valueOf(pages);
            bookYear = Integer.valueOf(year);
        }

        return new Book(title,author,publisher,bookPages,bookYear);
    }
}
