package ir.maktabsharif.repo.impl;

import ir.maktabsharif.model.Loan;

public class LoanRepoImpl extends BaseRepoImpl<Loan> {
    public LoanRepoImpl() {
        super(Loan.class);
    }

    @Override
    protected void setUpdate(Loan oldEntity, Loan newEntity) {
        oldEntity.setLoanStatus(newEntity.getLoanStatus());
        oldEntity.setReturnDate(newEntity.getReturnDate());
        oldEntity.setItem(newEntity.getItem());
    }

    @Override
    protected Long getId(Loan entity) {
        return entity.getId();
    }
}
