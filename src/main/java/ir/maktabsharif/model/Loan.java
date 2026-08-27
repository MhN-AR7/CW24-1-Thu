package ir.maktabsharif.model;

import ir.maktabsharif.enums.LoanStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Loan {
    /*
    `id`, `loanDate`, `dueDate`, `returnDate` (nullable), `status` (enum: `ACTIVE`, `RETURNED`, `OVERDUE`)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    @Column
    private LocalDate returnDate;
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;
    @ManyToOne
    private Member member;
    @ManyToOne
    private LibraryItem item;

    @PrePersist
    public void onCreate() {
        loanDate = LocalDate.now();
        returnDate = null;
        loanStatus = LoanStatus.ACTIVE;
    }

    public Loan(LocalDate dueDate, Member member, LibraryItem item) {
        this.dueDate = dueDate;
        this.member = member;
        this.item = item;
    }

    public Loan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LibraryItem getItem() {
        return item;
    }

    public void setItem(LibraryItem item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", loanStatus=" + loanStatus +
                '}';
    }
}
