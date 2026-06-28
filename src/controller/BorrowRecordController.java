package controller;

import services.BookService;
import services.BorrowRecordService;
import services.MemberService;
import utils.InputHelper;
import views.BookView;

public class BorrowRecordController {

   private final BorrowRecordService borrowRecordService;
    private final BookView bookView;

    public BorrowRecordController(BookService bookService, MemberService memberService,BorrowRecordService borrowRecordService){
        this.borrowRecordService = borrowRecordService;
        bookView = new BookView();
    }

    public void borrowBook() {

        String bookId = bookView.inputBookId();
        String memberId = InputHelper.readString("Enter Member Id: ");
        boolean success = borrowRecordService.getBorrowBook(bookId,memberId);


        if (success){
            System.out.println();
            bookView.displayMessage("BOOK BORROW SUCCESSFULLY");
        }else {
            System.out.println();
            bookView.displayMessage("BORROW FAILED");
        }
    }

    public void returnBook(){

        String bookId = bookView.inputBookId();
        boolean success = borrowRecordService.getReturnBook(bookId);
        if (success){
            System.out.println();
            bookView.displayMessage("BORROW BOOK RETURN SUCCESSFULLY");
        }else {
            System.out.println();
            bookView.displayMessage("RETURN FAILED ");
        }

    }


}
