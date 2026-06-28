package views;

import controller.LibraryController;
import model.Book;
import utils.InputHelper;

import java.util.List;

public class BookView {


    // for user choice
    public int getUserChoice() {
        return InputHelper.readInt("Enter Your Choice: ");
    }

    // to show book menu
    public void displayBookMenu() {

        System.out.println("============================================================");
        System.out.println("              BOOK MANAGEMENT");
        System.out.println("============================================================");

        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book");
        System.out.println("4. Update Book");
        System.out.println("5. Delete Book");
        System.out.println("6. Back");

        System.out.println("------------------------------------------------------------");

    }

    // create new book
    public Book inputBook(){

        //Create book via user input
        String id = InputHelper.readString("Enter Book Id: ");
        String title = InputHelper.readString("Enter Book Title: ");
        String author = InputHelper.readString("Enter Author: ");
        String category = InputHelper.readString("Enter Category: ");
        int year = InputHelper.readInt("Enter Year: ");

        return new Book(id,title,author,category,year,false);
    }

    // search book by book id
    public String inputBookId(){
        return InputHelper.readString("Enter Book Id: ");
    }

    // for view all books
    public void displayBooks(List<Book> books){

        printBookHeader(" BOOK LISTS");


        for (var book : books){
            printBookBody(book);
            }
    }

    // for single book
    public void displayBook(Book book){
        printBookHeader(" BOOK INFORMATION");
        printBookBody(book);

    }

    // for user message
    public void displayMessage(String message){
        System.out.println(message);
    }

    // update book
    public void inputUpdateBook(Book book) {

        //current book information
        printBookHeader("CURRENT BOOK INFORMATION");
        printBookBody(book);

        //new book data

        System.out.println("Current Title: " + book.getTitle());
        String newTitle = InputHelper.readString("Enter new title (Press Enter to keep current): ");
        if (!newTitle.isBlank()){
            book.setTitle(newTitle);
        }
        System.out.println("Current Author: " + book.getAuthor());
        String newAuthor = InputHelper.readString("Enter new author (Press Enter to keep current): ");
        if (!newAuthor.isBlank()){
            book.setAuthor(newAuthor);
        }
        System.out.println("Current Category: " + book.getCategory());
        String newCategory = InputHelper.readString("Enter new category (Press Enter to keep current): ");
        if (!newCategory.isBlank()){
            book.setCategory(newCategory);
        }
        System.out.println("Current Year: " + book.getYear());
        String newYear = InputHelper.readString("Enter new year (Press Enter to keep current): ");

        if (!newYear.isBlank()){

            // to check input data
            try {
                int year = Integer.parseInt(newYear);
                book.setYear(year);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Year!!");
            }

        }

    }

    private void printBookHeader(String title){
        System.out.println("==============================================================");
        System.out.printf("                    %s%n ",title);
        System.out.println("==============================================================");
        System.out.println();

        //table header
        System.out.printf("%-8s %-15s %-15s %-15s %-6s%n",
                "ID",
                "TITLE",
                "AUTHOR",
                "CATEGORY",
                "YEAR"
        );
        System.out.println("---------------------------------------------------------------------");

    }

    private void printBookBody(Book book){

        //table body

        System.out.printf("%-8s %-15s %-15s %-15s %-6s%n",
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getYear()
        );

        System.out.println();

    }
}
