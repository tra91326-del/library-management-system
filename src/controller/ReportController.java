package controller;

import dto.BorrowHistoryDTO;
import model.Book;
import services.ReportService;
import views.ReportView;

import java.util.List;

public class ReportController {

    private final ReportView reportView;
    private final ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
        reportView = new ReportView();
    }

    public void start(){
        boolean back = false;

        while (!back){
            reportView.displayMenu();
            int choice = reportView.getUserChoice();

            switch (choice){
                case 1:
                    viewAvailableBooks();
                    break;
                case 2:
                    viewCurrentBorrowedBooks();
                    break;
                case 3:
                    viewBorrowHistoryRecord();
                    break;
                case 4:
                    back = true;
                    break;
                default:{
                    System.out.println();
                    reportView.displayMessage("INVALID CHOICE");
                }
            }
        }
    }

    public void viewBorrowHistoryRecord(){
        List<BorrowHistoryDTO> historyDTOS = reportService.getBorrowHistory();
        if (historyDTOS.isEmpty()){
            System.out.println();
            reportView.displayMessage("HISTORY DATA NOT FOUND");
            return;
        }

        reportView.displayBorrowHistory(historyDTOS);

    }

    public void viewAvailableBooks(){
        List<Book> availableBook = reportService.getAvailableBooks();
        if (availableBook.isEmpty()){
            System.out.println();
            reportView.displayMessage("AVAILABLE BOOK NOT FOUND");
            return;
        }

        reportView.displayAvailableBooks(availableBook);

    }

    public void viewCurrentBorrowedBooks(){
        List<Book> currentBorrowedBook = reportService.getCurrentBorrowedBook();
        if (currentBorrowedBook.isEmpty()){
            System.out.println();
            reportView.displayMessage("BORROW BOOK NOT FOUND");
            return;
        }

        reportView.displayCurrentBorrowedBook(currentBorrowedBook);

    }


}
