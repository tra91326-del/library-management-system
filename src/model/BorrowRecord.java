package model;

import java.time.LocalDateTime;

public class BorrowRecord {

    private String memberId;
    private String bookId;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public BorrowRecord(String memberId, String bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = LocalDateTime.now();
        this.returnDate = null;
    }

    @Override
    public String toString() {
        return "Member Id: " + memberId +
                "\nBook Id: " + bookId +
                "\nBorrow Date: " + borrowDate +
                "\nReturn Date: " + returnDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
