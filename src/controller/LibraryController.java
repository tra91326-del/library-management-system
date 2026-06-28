package controller;

import model.Book;
import services.BookService;
import services.BorrowRecordService;
import services.MemberService;
import services.ReportService;
import views.BookView;
import views.MainMenuView;

import java.util.List;

public class LibraryController {

    private final MainMenuView mainMenuView;
    private final MemberController memberController;
    private final BookController bookController;
    private final BorrowRecordController borrowRecordController;
    private final ReportController reportController;

    public LibraryController() {


        // Creating a new BookService & MemberService would create a new empty ArrayList.
        // Create ONE  BookService  & MemberService instance.
        // All controllers use this same instance so they share the same book & member data.
        BookService bookService = new BookService();
        MemberService memberService = new MemberService();
        memberController = new MemberController(memberService);
        BorrowRecordService borrowRecordService = new BorrowRecordService(bookService,memberService);
        bookController = new BookController(bookService);
        ReportService reportService = new ReportService(bookService,memberService,borrowRecordService);
        borrowRecordController = new BorrowRecordController(bookService,memberService,borrowRecordService);
        reportController = new ReportController(reportService);
        mainMenuView = new MainMenuView();

    }

    public void start() {

        boolean running = true ;

        while (running){
            mainMenuView.displayMainMenu();
            int choice = mainMenuView.getUserChoice();
            switch (choice) {

                case 1:

                    bookController.start();
                    break;

                case 2:

                    memberController.start();
                    break;

                case 3:

                    borrowRecordController.borrowBook();
                    break;

                case 4:

                    borrowRecordController.returnBook();
                    break;

                case 5:

                    reportController.start();
                    break;

                case 6:
                    running = false;
                    System.out.println();
                    System.out.println("THANK YOU FOR USING LIBRARY MANAGEMENT SYSTEM");
                    break;

                default:
                    System.out.println("INVALID CHOICE.");
            }
        }

    }
    }