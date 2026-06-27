package controller;

import model.Book;
import services.BookService;
import views.BookView;
import views.MainMenuView;

import java.util.List;

public class LibraryController {

    private final MainMenuView mainMenuView;
    private final BookView bookView;
    private final BookService bookService;

    public LibraryController() {

        mainMenuView = new MainMenuView();
        bookView = new BookView();
        bookService = new BookService();
    }

    public void start() {

        boolean running = true ;

        while (running){
            mainMenuView.displayMainMenu();
            int choice = mainMenuView.getUserChoice();
            switch (choice) {

                case 1:
                    bookMenu();
                    break;

                case 2:
                    System.out.println("Member Management");
                    break;

                case 3:
                    System.out.println("Borrow Book");
                    break;

                case 4:
                    System.out.println("Return Book");
                    break;

                case 5:
                    System.out.println("Reports");
                    break;

                case 6:
                    running = false;
                    System.out.println("Thank you for using Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

    }

    private void bookMenu() {

        boolean back = false ;

        while (!back){

            bookView.displayBookMenu();

            int choice = bookView.getUserChoice();

                switch (choice){

                    case 1:
                        System.out.println("Add Book");
                        System.out.println("--------------------------------");
                        addBook();
                        break;

                    case 2:
                        System.out.println("View All Books");
                        System.out.println("--------------------------------");
                        viewAllBooks();
                        break;

                    case 3:
                        System.out.println("Search Book");
                        System.out.println("--------------------------------");
                        viewBookById();
                        break;

                    case 4:
                        System.out.println("Update Book");
                        updateBook();
                        System.out.println("--------------------------------");
                        break;

                    case 5:
                        System.out.println("Delete Book");
                        System.out.println("--------------------------------");
                        break;

                    case 6:
                        back = true;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }


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
