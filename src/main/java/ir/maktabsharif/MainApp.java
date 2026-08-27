package ir.maktabsharif;

import ir.maktabsharif.enums.FrequencyStatus;
import ir.maktabsharif.enums.LoanStatus;
import ir.maktabsharif.enums.MemberShipStatus;
import ir.maktabsharif.exception.BusinessException;
import ir.maktabsharif.model.*;
import ir.maktabsharif.service.impl.BookServiceImpl;
import ir.maktabsharif.service.impl.LoanServiceImpl;
import ir.maktabsharif.service.impl.MemberServiceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;

public class MainApp {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        MemberServiceImpl memberService = new MemberServiceImpl();
        LoanServiceImpl loanService = new LoanServiceImpl();


        Book book = new Book("sage velgard", 1370, 30, "978-964-05-0", "Sadegh Hedayat", 20);
        Magazine magazine = new Magazine("develober", 1405, 20, 42, "aa", FrequencyStatus.MONTHLY);
        Manuscript manuscript = new Manuscript("aa", 1400, 50, "iran", 500, true);

        Member member = new Member("Mahan", "mmm@exampe.com", LocalDate.of(2027, 12, 17), MemberShipStatus.ACTIVE, new HashSet<>());

        Loan loan = new Loan(LocalDate.of(2026, 9, 27), member, book);


        try {
            bookService.register(book);
            memberService.register(member);
            loanService.register(loan);
        }
        catch (BusinessException e) {
            throw new RuntimeException(e);
        }

        loanService.returnItem(loan);
    }
}
