package br.com.projetowebcadastro.bo;

import br.com.projetowebcadastro.dao.IBookDAO;
import br.com.projetowebcadastro.model.Book;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BookBusinessObject implements IBookBusinessObject{
    private final IBookDAO bookDAO;

    @Inject
    public BookBusinessObject(IBookDAO ibookDAO) {
        this.bookDAO = ibookDAO;
    }
    @Override
    public Book save(Book book) {
        valida(book);
        return bookDAO.save(book);
    }
    @Override
    public void valida(Book book) {
        if(Objects.isNull(book.getTitle())){
            throw new IllegalArgumentException("Livro inválido");
        }
    }
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public void remove(String id) {
        var bookOpt = bookDAO.findById(id);
        if(bookOpt.isEmpty()){
            throw new IllegalArgumentException("Id inválido");
        } else {
            bookDAO.remove(bookOpt.get());
        }
    }

    @Override
    public Book findById(String id) {
        Optional<Book> optionalBook = bookDAO.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }else {
            throw new IllegalArgumentException("Livro não encontrado");
        }
    }

    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }
}
