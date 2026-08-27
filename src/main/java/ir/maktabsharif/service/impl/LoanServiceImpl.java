package ir.maktabsharif.service.impl;

import ir.maktabsharif.enums.LoanStatus;
import ir.maktabsharif.enums.MemberShipStatus;
import ir.maktabsharif.exception.BusinessException;
import ir.maktabsharif.exception.InvalidDataException;
import ir.maktabsharif.model.LibraryItem;
import ir.maktabsharif.model.Loan;
import ir.maktabsharif.repo.LibraryItemRepo;
import ir.maktabsharif.repo.impl.LoanRepoImpl;
import ir.maktabsharif.util.Rule;

import java.time.LocalDate;

public class LoanServiceImpl extends BaseServiceImpl<Loan> {
    private final LibraryItemRepo itemRepo;
    private final LoanRepoImpl loanRepo;

    public LoanServiceImpl() {
        super(new LoanRepoImpl());

        itemRepo = new LibraryItemRepo();
        loanRepo = new LoanRepoImpl();
    }

    @Override
    public Loan register(Loan entity) throws BusinessException {
        validate(entity);

        itemRepo.decreaseCopies(entity.getItem());

        loanRepo.insert(entity);

        return entity;
    }

    @Override
    protected Long getId(Loan entity) {
        return entity.getId();
    }

    @Override
    public void validate(Loan loan) throws BusinessException {
        Rule.check(
                loan.getItem().getAvailableCopies() <= 0,
                InvalidDataException::new,
                "Not enough available books!"
        );

        Rule.check(
                loan.getMember().getMemberShipStatus().equals(MemberShipStatus.SUSPENDED),
                InvalidDataException::new,
                "Membership Status Suspended!"
        );
    }

    public void returnItem(Loan loan) {
        loan.setReturnDate(LocalDate.now());
        loan.setLoanStatus(LoanStatus.RETURNED);

        itemRepo.increaseCopies(loan.getItem());

        loanRepo.update(loan);
    }

    public Long countOfNonReturnedItems(){
        return new LoanRepoImpl().countOfNonReturnedItems();
    }
}
