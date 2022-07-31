package br.com.projetowebcadastro.dao;

import br.com.projetowebcadastro.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BookDAO implements IBookDAO{
    private static List<Book> bookData = new ArrayList<>();
    private static Integer id = 0;
    @Override
    public Book save(Book book) {
        id++;
        book.setId(id);
        bookData.add(book);
        return book;
    }
    @Override
    public List<Book> findAll() {
        return bookData;
    }

    @Override
    public void remove(Book book) {
        bookData.remove(book);
    }
    @Override
    public Optional<Book> findById(String id){
        for (Book bookSaved : bookData){
            if (bookSaved.getId().equals(Integer.valueOf(id))){
                return Optional.of(bookSaved);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Book book) {
        for (Book bookSaved: bookData) {
            if (bookSaved.getId().equals(book.getId())){
                bookSaved.setId(book.getId());
                bookSaved.setTitle(book.getTitle());
                bookSaved.setAuthor(book.getAuthor());
                bookSaved.setPublisher(book.getPublisher());
                bookSaved.setPages(book.getPages());
                bookSaved.setYear(book.getYear());
            }
        }
    }
}
