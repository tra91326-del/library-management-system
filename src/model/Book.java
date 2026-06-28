package model;

public class Book {

    private final String id;
    private String title;
    private String author;
    private String category;
    private int year;
    private  boolean borrowed;

    public Book(String id, String title, String author, String category, int year, boolean borrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {

        return "Book ID : " + id +
                "\nTitle : " + title +
                "\nAuthor : " + author +
                "\nCategory : " + category +
                "\nYear : " + year +
                "\n----------------------------";
    }

    public String getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
