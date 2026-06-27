package services;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private List<Book> books = new ArrayList<>();


    public void addBook(Book book){
        books.add(book);
    }

    public void deleteBook(String bookId){

    }

    public List<Book> getAllBooks(){
        return books;
    }

    public boolean existsBookId(String bookId){
        Book book = searchBookById(bookId);
        return book != null;
    }

    public Book searchBookById(String bookId){
        for (var book : books){
            if (book.getId().equals(bookId)){
                return book;
            }
        }
        return null;
    }
}
