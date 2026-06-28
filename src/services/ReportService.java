package services;

import dto.BorrowHistoryDTO;
import model.Book;
import model.BorrowRecord;
import model.Member;

import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private final BookService bookService;
    private final MemberService memberService;
    private final BorrowRecordService borrowRecordService;

    public ReportService(BookService bookService,MemberService memberService,BorrowRecordService borrowRecordService){
        this.bookService =  bookService;
        this.memberService = memberService;
        this.borrowRecordService = borrowRecordService;
    }

    public List<BorrowHistoryDTO> getBorrowHistory(){

        List<BorrowHistoryDTO> history = new ArrayList<>();

        List<BorrowRecord> borrowRecordList = borrowRecordService.getAllBorrowRecord();

        for (BorrowRecord borrowRecord : borrowRecordList){
            Member member = memberService.searchMemberById(borrowRecord.getMemberId());
            Book book = bookService.searchBookById(borrowRecord.getBookId());
            BorrowHistoryDTO borrowHistoryDTO = new BorrowHistoryDTO(
                    member.getName(),
                    book.getTitle(),
                    borrowRecord.getBorrowDate(),
                    borrowRecord.getReturnDate());

            history.add(borrowHistoryDTO);

        }

        return history;
    }

    public List<Book> getAvailableBooks(){
        List<Book> availableBookList = new ArrayList<>() ;
        List<Book> allBooks = bookService.getAllBooks();
        for (Book book : allBooks){
            if (!book.isBorrowed()){
                availableBookList.add(book);
            }
        }
        return availableBookList;
    }


    public List<Book> getCurrentBorrowedBook() {
        List<Book> currentBorrowedBookList = new ArrayList<>() ;
        List<Book> allBooks = bookService.getAllBooks();
        for (Book book : allBooks){
            if (book.isBorrowed()){
                currentBorrowedBookList.add(book);
            }
        }
        return currentBorrowedBookList;
    }
}
