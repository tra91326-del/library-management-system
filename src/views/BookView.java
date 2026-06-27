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

        System.out.println("=================================");
        System.out.println("  Book  Management ");
        System.out.println("=================================");

        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book");
        System.out.println("4. Update Book");
        System.out.println("5. Delete Book");
        System.out.println("6. Back");

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
            for (var book : books){
                System.out.println(book);

            }
    }

    // for single book
    public void displayBook(Book book){
        System.out.println(book);
    }

    // for user message
    public void displayMessage(String message){
        System.out.println(message);
    }

    // update book
    public void inputUpdateBook(Book book) {

        //current book information
        System.out.println("Current Book Information");
        System.out.println(book);
        System.out.println("----------------------");

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
}
