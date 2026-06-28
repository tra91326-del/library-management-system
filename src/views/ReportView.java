package views;

import dto.BorrowHistoryDTO;
import model.Book;
import model.BorrowRecord;
import utils.InputHelper;

import java.util.List;

public class ReportView {

    public void displayMenu(){
        System.out.println("============================================================");
        System.out.println("              REPORT MANAGEMENT");
        System.out.println("============================================================");

        System.out.println("1. Available Book");
        System.out.println("2. Current Borrow Books");
        System.out.println("3. Borrow History Record");
        System.out.println("4. Back");
        System.out.println();
        System.out.println("------------------------------------------------------------");
    }

    public void displayAvailableBooks(List<Book> books){

        //header
        System.out.println("==============================================================");
        System.out.println("                    AVAILABLE BOOKS");
        System.out.println("==============================================================");
        System.out.println();

        //table header
        System.out.printf(
                "%-8s %-25s %-20s %-15s %-6s%n",
                "ID",
                "TITLE",
                "AUTHOR",
                "CATEGORY",
                "YEAR"
        );

        //table body
        System.out.println("---------------------------------------------------------------------------");
        for (Book book : books) {

            System.out.printf(
                    "%-8s %-25s %-20s %-15s %-6d%n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getCategory(),
                    book.getYear()
            );

        }

        //footer
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Total Available Books : " + books.size());
        System.out.println("==============================================================");


    }

    public void displayCurrentBorrowedBook(List<Book> books){
        System.out.println("==============================================================");
        System.out.println("                    CURRENT BORROW BOOKS");
        System.out.println("==============================================================");
        System.out.println();

        System.out.printf(
                "%-8s %-25s %-20s %-15s %-6s%n",
                "ID",
                "TITLE",
                "AUTHOR",
                "CATEGORY",
                "YEAR"
        );

        System.out.println("---------------------------------------------------------------------------");
        for (Book book : books) {

            System.out.printf(
                    "%-8s %-25s %-20s %-15s %-6d%n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getCategory(),
                    book.getYear()
            );

        }

        System.out.println();
        System.out.println("==============================================================");



    }

    public void displayBorrowHistory(List<BorrowHistoryDTO> historyDTOS){

        //header
        System.out.println("==============================================================");
        System.out.println("                    BORROW HISTORY RECORD");
        System.out.println("==============================================================");
        System.out.println();

        //table header
        System.out.printf("%-18s %-25s %-30s %-30s%n",
                "MEMBER NAME",
                "BOOK TITLE",
                "BORROW DATE",
                "RETURN DATE"
                );
        System.out.println("---------------------------------------------------------------------------");


        //body
        for (BorrowHistoryDTO dto : historyDTOS){

            System.out.printf("%-18s %-25s %-30s %-30s%n",
                        dto.memberName(),
                        dto.bookTitle(),
                    dto.borrowDate(),
                    dto.returnDate()

                    );
        }


        System.out.println();
        System.out.println("==============================================================");


    }

    public void displayMessage(String message){
        System.out.println(message);
    }

    public int getUserChoice() {
        System.out.println();
        return InputHelper.readInt("Enter Your Choice:  ");
    }

}
