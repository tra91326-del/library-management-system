package controller;

import model.Book;
import services.BookService;
import views.BookView;

public class BookController {

    private final BookService bookService;
    private final BookView bookView;

    public BookController(BookService bookService){
        this.bookService =bookService;
        bookView = new BookView();
    }

    public void start (){
        boolean back = false ;

        while (!back){

            bookView.displayBookMenu();

            int choice = bookView.getUserChoice();

            switch (choice){

                case 1:
                    addBook();
                    break;

                case 2:
                     viewAllBooks();
                    break;

                case 3:
                      viewBookById();
                    break;

                case 4:
                     updateBook();
                    break;

                case 5:
                     deleteBook();
                    break;

                case 6:
                    back = true;
                    break;

                default:
                    System.out.println("INVALID CHOICE");
            }


        }

    }

    private void deleteBook() {
        String bookId = bookView.inputBookId();
        boolean deleted = bookService.deleteBook(bookId);

        if (deleted){
            bookView.displayMessage("Book deleted successfully");
        }else {
            bookView.displayMessage("Book not found!!");
        }
    }

    private void updateBook() {
        String bookId = bookView.inputBookId();
        Book book = bookService.searchBookById(bookId);
        if (book == null){
            System.out.println("Book Not Found!!");
            return;
        }
        bookView.inputUpdateBook(book);
        bookView.displayMessage("Book update Successfully");
    }

    private void viewBookById() {
        String bookId = bookView.inputBookId();
        Book book = bookService.searchBookById(bookId);
        if (book == null){
            System.out.println("Book Not Found!!");
            return;
        }
        bookView.displayBook(book);
    }


    private void viewAllBooks() {
        var books = bookService.getAllBooks();
        if (books.isEmpty()){
            bookView.displayMessage("No Book Available!!");
            return;
        }
        bookView.displayBooks(books);
    }

    private void addBook() {

        Book book = bookView.inputBook();
        if (bookService.existsBookId(book.getId())){
            bookView.displayMessage("Book Id already exists");
            return;
        }
        bookService.addBook(book);
        bookView.displayMessage("Book added Successfully");
    }

    }

