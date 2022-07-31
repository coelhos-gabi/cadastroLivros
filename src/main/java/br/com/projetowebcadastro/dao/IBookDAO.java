package br.com.projetowebcadastro.dao;

import br.com.projetowebcadastro.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {

    Book save(Book book);
    List<Book> findAll();
    void remove(Book book);
    Optional<Book> findById(String id);
    void update(Book book);
}
