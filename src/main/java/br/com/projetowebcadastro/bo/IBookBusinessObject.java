package br.com.projetowebcadastro.bo;

import br.com.projetowebcadastro.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookBusinessObject {
    Book save(Book book);
    void valida(Book book);
    List<Book> findAll();
    void remove(String id);
    Book findById(String id);
    void update(Book book);
}
