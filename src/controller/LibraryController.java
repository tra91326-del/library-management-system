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
    private final MemberController memberController;

    public LibraryController() {

        mainMenuView = new MainMenuView();
        bookView = new BookView();
        bookService = new BookService();
        memberController = new MemberController();
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
                    memberController.start();
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
                        System.out.println("--------------------------------");
                        updateBook();
                        break;

                    case 5:
                        System.out.println("Delete Book");
                        System.out.println("--------------------------------");
                        deleteBook();
                        break;

                    case 6:
                        back = true;
                        break;

                    default:
                        System.out.println("Invalid choice.");
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
