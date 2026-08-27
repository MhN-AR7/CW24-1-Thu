package ir.maktabsharif.model;

import ir.maktabsharif.enums.MemberShipStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member {
    /*
    `id`, `fullName`, `email`, `membershipDate`, `membershipStatus` (enum: `ACTIVE`, `SUSPENDED`, `EXPIRED`)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private LocalDate membershipDate;
    @Enumerated(EnumType.STRING)
    private MemberShipStatus memberShipStatus;
    @OneToMany(mappedBy = "member")
    private Set<Loan> loans = new HashSet<>();

    public Member(String fullName, String email, LocalDate membershipDate, MemberShipStatus memberShipStatus, Set<Loan> loans) {
        this.fullName = fullName;
        this.email = email;
        this.membershipDate = membershipDate;
        this.memberShipStatus = memberShipStatus;
        this.loans = loans;
    }

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public MemberShipStatus getMemberShipStatus() {
        return memberShipStatus;
    }

    public void setMemberShipStatus(MemberShipStatus memberShipStatus) {
        this.memberShipStatus = memberShipStatus;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", membershipDate=" + membershipDate +
                ", memberShipStatus=" + memberShipStatus +
                '}';
    }
}
