package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record BorrowHistoryDTO(String memberName, String bookTitle, LocalDateTime borrowDate,
                               LocalDateTime returnDate) {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String toString() {
        return "Member Name: " + memberName +
                "\nBook Title: " + bookTitle +
                "\nBorrow Date: " + borrowDate.format(FORMATTER) +
                "\nReturn Date: " + returnDate.format(FORMATTER);
    }
}
