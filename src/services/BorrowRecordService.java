package services;

import model.Book;
import model.BorrowRecord;
import model.Member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BorrowRecordService {

    private final BookService bookService;
    private final MemberService memberService;

    private final List<BorrowRecord> records = new ArrayList<>();

    public BorrowRecordService(BookService bookService,MemberService memberService){
        this.bookService = bookService;
        this.memberService = memberService;

    }

    public List<BorrowRecord> getAllBorrowRecord(){
        return records;
    }


    public boolean getBorrowBook(String bookId, String memberId) {

        Book book = bookService.searchBookById(bookId);
        Member member = memberService.searchMemberById(memberId);

        System.out.println(book);


        if (book == null || member == null) {
            return false;
        }
        if (book.isBorrowed()) {
            return false;
        }
            BorrowRecord borrowRecord = new BorrowRecord(memberId, bookId);
            records.add(borrowRecord);
        book.setBorrowed(true);
            return true;

    }

    public boolean getReturnBook(String bookId){

        Book book = bookService.searchBookById(bookId);
        if (book == null){
            return false;
        }
        if (!book.isBorrowed()){
            return false;
        }
        for (BorrowRecord br : records){
            if (br.getBookId().equals(bookId) && br.getReturnDate() == null){
                br.setReturnDate(LocalDateTime.now());
                book.setBorrowed(false);
                return true;
            }
        }

        return false;

    }

}
